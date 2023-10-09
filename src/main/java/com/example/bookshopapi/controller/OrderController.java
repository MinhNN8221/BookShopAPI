package com.example.bookshopapi.controller;

import com.example.bookshopapi.config.jwt.JwtUtil;
import com.example.bookshopapi.dto.objectdto.orderdto.OrderDto;
import com.example.bookshopapi.dto.response.Error;
import com.example.bookshopapi.dto.response.Message;
import com.example.bookshopapi.dto.response.order.OrderDetailResponse;
import com.example.bookshopapi.dto.response.order.OrderResponse;
import com.example.bookshopapi.entity.*;
import com.example.bookshopapi.service.*;
import com.example.bookshopapi.util.OrderUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/orders")
@AllArgsConstructor
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private CartItemService cartItemService;
    @Autowired
    private ShippingService shippingService;
    @Autowired
    private ReceiverService receiverService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private WishListItemService wishListItemService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("")
    public ResponseEntity<?> getOrder(@RequestHeader("user-key") String userKey) {
        if (jwtUtil.isTokenExpired(userKey.replace("Bearer ", ""))) {
            int customerId = Integer.parseInt(jwtUtil.extractId(userKey.replace("Bearer ", "")));
            List<OrderDetail> orderDetails = orderDetailService.getAllByCustomerId(customerId);
            List<Order> orders = orderService.getAllByCustomerId(customerId);
            List<OrderDto> orderDtos = new OrderUtil().addToOrderDto(orders, customerId, orderDetails);
            return ResponseEntity.ok(new OrderResponse(orderDtos.size(), orderDtos));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new Error(401, "AUT_02", "Userkey không hợp lệ hoặc đã hết hạn!", "USER_KEY"));
        }
    }

    @PostMapping("")
    public ResponseEntity<?> createOrder(@RequestHeader("user-key") String userKey,
                                         @RequestParam("cart_id") String cartId,
                                         @RequestParam("shipping_id") int shippingId,
                                         @RequestParam("receiver_id") int receiverId) throws MessagingException, UnsupportedEncodingException {
        if (jwtUtil.isTokenExpired(userKey.replace("Bearer ", ""))) {
            int customerId = Integer.parseInt(jwtUtil.extractId(userKey.replace("Bearer ", "")));
            List<CartItem> cartItems = cartItemService.getAllByCustomerId(customerId);
            if (cartItems.size() == 0) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Error(404, "CART_02", "Giỏ hàng của bạn không có sản phẩm để thanh toán!", ""));
            } else {
                BigDecimal subTotal = new BigDecimal("0");
                for (CartItem cartItem : cartItems) {
                    subTotal = subTotal.add(cartItem.getBook().getDiscounted_price());
                }
                Customer customer = customerService.findById(customerId);
                Receiver receiver=receiverService.findById(receiverId);
                Order order = new Order();
                order.setCreateOn(LocalDateTime.now());
                order.setAddress(receiver.getAddress());
                order.setReceiverName(receiver.getReceiverName());
                order.setReceiverPhone(receiver.getReceiverPhone());
                order.setShipping(shippingService.findById(shippingId));
                order.setTotalAmount(subTotal);
                order.setOrderStatus(new OrderStatus(1, "Đang được chuẩn bị"));
                order.setCustomer(customer);
                emailService.sendMailOrder(receiver, customer, order, cartItems);
                orderService.save(order);
                orderDetailService.save(order, cartItems);
                cartItemService.emptyCart(cartId);
                return ResponseEntity.ok(new Message("Đặt hàng thành công"));
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new Error(401, "AUT_02", "Userkey không hợp lệ hoặc đã hết hạn!", "USER_KEY"));
        }
    }

    @GetMapping("/{order_id}")
    public ResponseEntity<?> getOrderInfo(@RequestHeader("user-key") String userKey,
                                          @PathVariable("order_id") int orderId) {
        if (jwtUtil.isTokenExpired(userKey.replace("Bearer ", ""))) {
            int customerId = Integer.parseInt(jwtUtil.extractId(userKey.replace("Bearer ", "")));
            List<OrderDetail> orderDetails = orderDetailService.getAllByOrderId(orderId);
            Order order = orderService.getOrderById(orderId);
            List<Book> books = wishListItemService.getAllBooksInWishlist(customerId);
            if (order == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Error(404, "ORDER_01", "Không có đơn hàng chi tiết cho đơn hàng này!", "orderId"));
            } else {
                OrderDetailResponse response = new OrderUtil().addToOrderDetail(order, orderDetails, customerId, books);
                return ResponseEntity.ok(response);
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new Error(401, "AUT_02", "Userkey không hợp lệ hoặc đã hết hạn!", "USER_KEY"));
        }
    }
}

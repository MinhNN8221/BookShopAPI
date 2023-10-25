package com.example.bookshopapi.entity;

import lombok.*;

import javax.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "total_amount", precision = 10, scale = 2)
    private BigDecimal totalAmount;
    @Column(name = "create_on")
    private LocalDateTime createOn;
    @Column(name = "shipped_on")
    private LocalDateTime shippedOn;
    @Column(name = "address", columnDefinition = "VARCHAR(255)")
    private String address;
    @Column(name = "receiver_name", columnDefinition = "VARCHAR(100)")
    private String receiverName;
    @Column(name = "receiver_phone", columnDefinition = "VARCHAR(10)")
    private String receiverPhone;
    //    @OneToMany(mappedBy = "order")
//    List<OrderDetail> orderDetails;
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "order_status_id")
    private OrderStatus orderStatus;
    @ManyToOne
    @JoinColumn(name = "shipping_id")
    private Shipping shipping;
    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;
}

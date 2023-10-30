package com.example.bookshopapi.service;

import com.example.bookshopapi.entity.Book;
import com.example.bookshopapi.entity.Cart;
import com.example.bookshopapi.entity.CartItem;
import com.example.bookshopapi.repository.CartItemRepo;
import com.example.bookshopapi.repository.CartRepo;
import com.example.bookshopapi.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CartItemService {
    @Autowired
    private CartItemRepo cartItemRepo;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CartRepo cartRepo;

    public CartItem save(CartItem cartItem) {
        return cartItemRepo.save(cartItem);
    }

    public CartItem findByIdAndCustomerId(int cartItemId, int customerId) {
        return cartItemRepo.findByIdAndCartCustomerId(cartItemId, customerId);
    }

    public CartItem findByBookIdAndCustomerId(int bookId, int customerId) {
        return cartItemRepo.findByBookIdAndCartCustomerId(bookId, customerId);
    }

    public List<CartItem> getAllByCustomerId(int customerId) {
        return cartItemRepo.getAllByCartCustomerId(customerId);
    }

    public void deleteByCartItemId(int itemCartId, int customerId) {
        cartItemRepo.deleteByIdAndCartCustomerId(itemCartId, customerId);
    }

    public List<Book> getAllBooksInCart(int customerId) {
        return cartItemRepo.getAllBooksInCart(customerId);
    }

    public void emptyCart(String cartId) {
        cartItemRepo.deleteByCartId(cartId);
    }

    public void addWishlistToCart(int customerId, List<Book> booksInWishlist) {
        List<Book> booksInCart = getAllBooksInCart(customerId);
        for (Book book : booksInWishlist) {
            if(book.getQuantity()-book.getQuantitySold()>0){
                if (booksInCart.contains(book)) {
                    CartItem cartItem = findByBookIdAndCustomerId(book.getId(), customerId);
                    cartItem.setQuantity(cartItem.getQuantity() + 1);
                    cartItemRepo.save(cartItem);
                } else {
                    Cart cart = cartRepo.findByCustomerId(customerId);
                    CartItem cartItem = new CartItem();
                    cartItem.setAddOn(LocalDateTime.now());
                    cartItem.setQuantity(1);
                    cartItem.setBook(book);
                    cartItem.setCart(cart);
                    cartItemRepo.save(cartItem);
                }
                book.setQuantitySold(book.getQuantitySold()+1);
                productRepo.save(book);
            }
        }
    }

    public void restoreQuantity(List<CartItem> cartItems) {
        for (CartItem cartItem : cartItems) {
            Book book = cartItem.getBook();
            book.setQuantitySold(book.getQuantitySold() - cartItem.getQuantity());
            productRepo.save(book);
        }
    }
}

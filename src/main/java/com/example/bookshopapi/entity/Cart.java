package com.example.bookshopapi.entity;

import lombok.*;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "cart")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    @Column(name = "id")
    private String id;
//    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
//    private List<CartItem> cartItems;
    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}

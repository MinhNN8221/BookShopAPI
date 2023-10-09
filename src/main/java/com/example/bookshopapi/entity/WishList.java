package com.example.bookshopapi.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "wishlist")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
//    @OneToMany(mappedBy = "wishList", cascade = CascadeType.ALL)
//    private List<Wishlistitem> wishlistitems;
}

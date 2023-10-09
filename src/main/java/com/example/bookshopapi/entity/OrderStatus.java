package com.example.bookshopapi.entity;

import lombok.*;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "order_status")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "status", columnDefinition = "VARCHAR(100)")
    private String status;
//    @OneToMany(mappedBy = "orderStatus", cascade = CascadeType.ALL)
//    private List<Order> orders;
}

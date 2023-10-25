package com.example.bookshopapi.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "payment")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "payment_method", columnDefinition = "VARCHAR(100)")
    private String paymentMethod;
}

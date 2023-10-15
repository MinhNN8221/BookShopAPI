package com.example.bookshopapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customer")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @NotNull
    @Column(name = "name", columnDefinition = "VARCHAR(100)")
    private String name;
    @NotNull
    @Column(name = "email", columnDefinition = "VARCHAR(255)")
    private String email;
    @NotNull
    @JsonIgnore
    @Column(name = "password", columnDefinition = "VARCHAR(255)")
    private String password;
    @Column(name = "address", columnDefinition = "VARCHAR(100)")
    private String address;
    @Column(name = "mob_phone", columnDefinition = "VARCHAR(10)")
    private String mobPhone;
    @Column(name = "date_of_birth", columnDefinition = "VARCHAR(100)")
//    @Temporal(TemporalType.DATE) // Xác định kiểu thời gian
    private LocalDate dateOfBirth;
    @Column(name = "gender", columnDefinition = "VARCHAR(10)")
    private String gender;
    @Column(name = "avatar")
    private String avatar;
//    @OneToMany(mappedBy = "customer")
//    private List<Order> orders;
//    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
//    private WishList wishList;
//    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
//    private Cart cart;
}

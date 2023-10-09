package com.example.bookshopapi.entity;

import lombok.*;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "supplier")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name", columnDefinition = "VARCHAR(100)")
    private String name;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
//    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
//    private List<Book> books;
}

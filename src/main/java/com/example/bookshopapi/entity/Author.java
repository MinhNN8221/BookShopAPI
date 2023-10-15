package com.example.bookshopapi.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "author")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NotNull
    @Column(name = "name", columnDefinition = "VARCHAR(100)")
    private String name;
    @NotNull
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    @NotNull
    @Column(name = "avatar", columnDefinition = "VARCHAR(200)")
    private String avatar;
//    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
//    private List<Book> books;
}

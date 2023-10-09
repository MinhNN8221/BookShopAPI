package com.example.bookshopapi.entity;

import com.sun.istack.internal.NotNull;
import lombok.*;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "book")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
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
    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;
    @NotNull
    @Column(name = "discounted_price", precision = 10, scale = 2)
    private BigDecimal discounted_price;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "quantity_sold")
    private int quantitySold;
    @Column(name = "image", columnDefinition = "VARCHAR(200)")
    private String image;
    @Column(name = "image_2", columnDefinition = "VARCHAR(200)")
    private String image_2;
    @Column(name = "thumbnail", columnDefinition = "VARCHAR(100)")
    private String thumbnail;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @Column(name = "banner_url")
    private String banner;
//    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
//    private List<OrderDetail> orderDetails;
//    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
//    private List<CartItem> cartItems;
}

package com.example.bookshopapi.dto.request;

import com.example.bookshopapi.entity.Author;
import com.example.bookshopapi.entity.Category;
import com.example.bookshopapi.entity.Supplier;
import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.File;
import java.math.BigDecimal;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {
    private int id;
    private String name;
    private String description;
    private BigDecimal price;
    private BigDecimal discounted_price;
    private int quantity;
    private String image;
    private Author author;
    private Supplier supplier;
    private Category category;
    private Boolean isBannerSelected;
    private String fileName;
}

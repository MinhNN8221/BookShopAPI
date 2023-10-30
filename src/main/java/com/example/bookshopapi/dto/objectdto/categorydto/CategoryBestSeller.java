package com.example.bookshopapi.dto.objectdto.categorydto;

import com.example.bookshopapi.entity.Category;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryBestSeller {
    private Category category;
    private Long totalSold;
}

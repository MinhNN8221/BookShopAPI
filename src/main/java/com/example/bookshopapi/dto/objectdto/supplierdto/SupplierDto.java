package com.example.bookshopapi.dto.objectdto.supplierdto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SupplierDto {
    private int supplier_id;
    private String supplier_name;
}

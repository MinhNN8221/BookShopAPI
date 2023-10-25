package com.example.bookshopapi.dto.response.supplier;

import com.example.bookshopapi.dto.objectdto.supplierdto.SupplierDto;
import com.example.bookshopapi.entity.Supplier;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SupplierResponse {
    private int count;
    private List<Supplier> rows;
}

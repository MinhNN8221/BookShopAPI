package com.example.bookshopapi.util;

import com.example.bookshopapi.dto.objectdto.supplierdto.SupplierDto;
import com.example.bookshopapi.entity.Supplier;

import java.util.ArrayList;
import java.util.List;

public class SupplierUtil {
    public List<SupplierDto> addSupplierDto(List<Supplier> suppliers) {
        List<SupplierDto> supplierDtos = new ArrayList<>();
        for (Supplier supplier : suppliers) {
            SupplierDto supplierDto = new SupplierDto(supplier.getId(), supplier.getName());
            supplierDtos.add(supplierDto);
        }
        return supplierDtos;
    }
}

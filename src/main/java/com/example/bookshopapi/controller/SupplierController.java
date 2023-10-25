package com.example.bookshopapi.controller;

import com.example.bookshopapi.dto.response.Message;
import com.example.bookshopapi.dto.response.supplier.SupplierResponse;
import com.example.bookshopapi.entity.Supplier;
import com.example.bookshopapi.service.SupplierService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/supplier")
@AllArgsConstructor
@Slf4j
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @GetMapping("")
    public ResponseEntity<?> getAllSuppliers() {
        List<Supplier> suppliers = supplierService.getAllSuppliers();
//        List<SupplierDto> supplierDtos=new SupplierUtil().addSupplierDto(suppliers);
        SupplierResponse response = new SupplierResponse(suppliers.size(), suppliers);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addSupplier(@RequestBody Supplier supplierRequest) {
        List<Supplier> suppliers = supplierService.getAllSuppliers();
        List<String> supplierNames = new ArrayList<>();
        for (Supplier supplier : suppliers) {
            supplierNames.add(supplier.getName());
        }
        if (supplierNames.contains(supplierRequest.getName())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new Message("Nhà xuất bản này đã tồn tại trong hệ thống"));
        } else {
            supplierService.addSupplier(supplierRequest);
            return ResponseEntity.ok(new Message("Đã thêm nhà xuất bản thành công!"));
        }
    }
}

package com.example.bookshopapi.dto.response.order;

import com.example.bookshopapi.dto.objectdto.orderdto.OrderDto;
import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderResponse {
    private int count;
    private List<OrderDto> orders;
}

package com.example.bookshopapi.dto.response.receiver;

import com.example.bookshopapi.dto.objectdto.receiver.ReceiverDto;
import com.example.bookshopapi.entity.Receiver;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReceiverResponse {
    private int count;
    private List<ReceiverDto> receivers;
}

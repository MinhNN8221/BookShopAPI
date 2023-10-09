package com.example.bookshopapi.dto.objectdto.receiver;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReceiverDto {
    private int receiver_id;
    private String receiver_name;
    private String receiver_phone;
    private String receiver_address;
    private int isDefault;
    private int customer_id;
}

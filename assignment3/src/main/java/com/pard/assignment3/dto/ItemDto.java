package com.pard.assignment3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
    private String itemName;
    private int itemPrice;
    private int itemQuantity;
}

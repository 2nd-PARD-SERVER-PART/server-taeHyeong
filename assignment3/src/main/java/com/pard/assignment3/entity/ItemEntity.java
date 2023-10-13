package com.pard.assignment3.entity;

import com.pard.assignment3.dto.ItemDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String itemName;
    private int itemPrice;
    private int itemQuantity;
    @CreationTimestamp
    private Timestamp itemTime;

    public ItemEntity(ItemDto itemDto) {
        this.itemName = itemDto.getItemName();
        this.itemPrice = itemDto.getItemPrice();
        this.itemQuantity = itemDto.getItemQuantity();
    }
}

package com.server.Hw2.folder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private int id;
    private String name;
    private int price;
    private int number;
}
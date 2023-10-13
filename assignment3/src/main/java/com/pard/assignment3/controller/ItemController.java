package com.pard.assignment3.controller;

import com.pard.assignment3.dto.ItemDto;
import com.pard.assignment3.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemController {
    private final ItemService itemService;
    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/add")
    public String addItem(@RequestBody ItemDto itemDto) {
        return itemService.addItem(itemDto);
    }

    @GetMapping("/findAll")
    public String findAll() {
        return itemService.findAll();
    }

    @GetMapping("/findOne/{id}")
    public String findOne(@PathVariable Integer id) {
        return itemService.findOne(id);
    }

    @PatchMapping("/update/{id}")
    public String update(@PathVariable Integer id, @RequestBody ItemDto itemDto) {
        return itemService.updateOne(id, itemDto);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        return itemService.delete(id);
    }
}

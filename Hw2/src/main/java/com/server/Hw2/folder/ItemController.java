package com.server.Hw2.folder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
    private final ItemRepository itemRepository;
    @Autowired
    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @PostMapping("/add")
    public String itemAdd(@RequestBody Item item) {
        itemRepository.save(item);
        return "상품 추가";
    }

    @GetMapping("/findAll")
    public List<Item> itemFind() {
        List<Item> itemList = itemRepository.findAll();
        return itemList;
    }

    @GetMapping("/findOne/{id}")
    public Item itemFindOne(@PathVariable Integer id) {
        Item item = itemRepository.findById(id);
        return item;
    }

    @PatchMapping("/update/{id}")
    public String itemUpdate(@PathVariable Integer id, @RequestBody Item item) {
        itemRepository.update(id, item);
        return "상품 변경";
    }

    @DeleteMapping("/delete/{id}")
    public String itemDelete(@PathVariable Integer id) {
        itemRepository.delete(id);
        return "상품 제거";
    }
}

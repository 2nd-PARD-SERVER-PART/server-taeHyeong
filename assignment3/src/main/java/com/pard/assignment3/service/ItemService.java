package com.pard.assignment3.service;

import com.pard.assignment3.dto.ItemDto;
import com.pard.assignment3.entity.ItemEntity;
import com.pard.assignment3.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;
    @Autowired
    public ItemService(ItemRepository itemRepository) {this.itemRepository= itemRepository;}

    public String addItem(ItemDto itemDto) {
        ItemEntity item = new ItemEntity();
        if(itemRepository.existsByItemName(itemDto.getItemName())) {
            return "이미 존재하는 이름입니다.";
        }
        else if(itemDto.getItemPrice() >= 50000) {
            return "상품 가격이 너무 높습니다.";
        }
        else {
            itemRepository.save(item);
            return "추가 완료";
        }
    }

    public String findAll() {
        List<ItemEntity> items;
        items = itemRepository.findAll();
        return "검색 완료";
    }

    public String findOne(Integer id) {
        ItemEntity item;
        item = itemRepository.findById(id).get();
        return "검색 완료";
    }

    @Transactional
    public String updateOne(Integer id, ItemDto itemDto) {
        ItemEntity item;
        item = itemRepository.findById(id).get();
        if(itemRepository.existsByItemName(itemDto.getItemName())) {
            return "이미 존재하는 이름입니다.";
        }
        else if(itemDto.getItemPrice() >= 50000) {
            return "가격이 너무 높습니다.";
        }
        else {
            if(itemDto.getItemName() != null && itemDto.getItemName().isEmpty()) {
                item.setItemName(itemDto.getItemName());
                return "업데이트 하였습니다.";
            }
            else {
                return "제대로 입력하세요";
            }
        }
    }

    public String delete(Integer id) {
        itemRepository.deleteById(id);
        return "삭제 성공";
    }
}

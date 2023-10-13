package com.pard.assignment3.repository;

import com.pard.assignment3.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {
    boolean existsByItemName(String itemName);
    List<ItemEntity> findAllByOrderByItemPriceAsc();
    List<ItemEntity> findAllByOrderByItemQuantity();
    List<ItemEntity> findAllByOrderByItemTime();
}
package com.server.Hw2.folder;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {
    private static final Map<Integer, Item> mart = new HashMap<>();

    public Item save(Item item) {
        int order = mart.size() + 1;
        item.setId(order);
        mart.put(order, item);
        return item;
    }

    public Item findById(Integer id) {
        return mart.get(id);
    }

    public List<Item> findAll() {
        return new ArrayList<>(mart.values());
    }

    public void update(Integer id, Item updateParams) {
        Item findItem = findById(id);
        findItem.setName(updateParams.getName());
        findItem.setPrice(updateParams.getPrice());
        findItem.setNumber(updateParams.getNumber());
    }

    public void delete(Integer id) {
        mart.remove(id);
    }
}

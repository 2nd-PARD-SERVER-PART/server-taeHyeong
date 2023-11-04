package pard.assignment4.controller.item;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pard.assignment4.dto.item.request.ItemCreateRequest;
import pard.assignment4.dto.item.request.ItemSelledRequest;
import pard.assignment4.dto.item.response.ItemResponse;
import pard.assignment4.entity.item.Item;
import pard.assignment4.service.item.ItemService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ItemController {
    private final ItemService itemService;

    @PostMapping("/item")
    public ResponseEntity<Item> registItem(@RequestBody ItemCreateRequest request, @RequestParam Long userId) {
        Item registItem = itemService.registItem(request, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(registItem);
    }

    @PatchMapping("/sell")
    public ResponseEntity<Item> sellItem(@RequestBody ItemSelledRequest request) {
        Item selledItem = itemService.sellItem(request.getTitle());
        return ResponseEntity.status(HttpStatus.OK).body(selledItem);
    }

    @GetMapping("/items")
    public ResponseEntity<List<ItemResponse>> findAllItems() {
        List<ItemResponse> items = itemService.findAll()
                .stream()
                .map(ItemResponse::new)
                .toList();
        return ResponseEntity.ok().body(items);
    }

    @GetMapping
    public ResponseEntity<ItemResponse> findItem(@RequestParam String title) {
        Item item = itemService.findByTitle(title);
        if (item == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new ItemResponse(item));
    }

    @DeleteMapping("/items/{itemId}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long itemId) {
        itemService.delete(itemId);

        return ResponseEntity.ok()
                .build();
    }

}

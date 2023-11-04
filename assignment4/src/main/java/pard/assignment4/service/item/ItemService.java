package pard.assignment4.service.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pard.assignment4.dto.item.request.ItemCreateRequest;
import pard.assignment4.entity.item.Item;
import pard.assignment4.entity.user.User;
import pard.assignment4.repository.item.ItemRepository;
import pard.assignment4.repository.user.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    @Transactional
    public Item registItem(ItemCreateRequest request, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("사용자가" +
                "존재하지 않음"));
        Item item = itemRepository.save(request.toEntity());
        item.setUser(user);
        user.getRegistedItems().add(item);

        return itemRepository.save(item);
    }

    public Item sellItem(String title) {
        Item item = itemRepository.findByTitle(title)
                .orElseThrow(() -> new IllegalArgumentException("해당 이름의 물품이 존재하지 않음"));

        User user = item.getUser();
        user.getRegistedItems().remove(item);
        item.setUser(null);

        return itemRepository.save(item);
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Item findByTitle(String title) {
        return itemRepository.findByTitle(title).orElseThrow(
                ()-> new IllegalArgumentException("해당 이름의 물품이 존재하지 않음")
        );
    }

    public void delete(Long itemId) {
        itemRepository.deleteById(itemId);
    }
}

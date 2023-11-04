package pard.assignment4.repository.item;

import org.springframework.data.jpa.repository.JpaRepository;
import pard.assignment4.entity.item.Item;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Optional<Item> findByTitle(String title);
}

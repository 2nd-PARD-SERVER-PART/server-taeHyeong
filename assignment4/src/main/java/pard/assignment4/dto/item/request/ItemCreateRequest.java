package pard.assignment4.dto.item.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pard.assignment4.entity.item.Item;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ItemCreateRequest {
    private String title;
    private String category;

    public Item toEntity() {
        return Item.builder().title(title).category(category).build();
    }
}

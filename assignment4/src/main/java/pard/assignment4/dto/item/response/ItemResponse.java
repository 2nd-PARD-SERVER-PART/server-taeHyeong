package pard.assignment4.dto.item.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pard.assignment4.dto.user.response.UserResponse;
import pard.assignment4.entity.item.Item;

@NoArgsConstructor
@Getter
public class ItemResponse {
    private Long id;
    private String title;
    private String category;
    private UserResponse user;

    public ItemResponse(Item item) {
        this.id = item.getId();
        this.title = item.getTitle();
        this.category = item.getCategory();
        if(item.getUser() != null) {
            this.user = new UserResponse(item.getUser());
        }
    }
}

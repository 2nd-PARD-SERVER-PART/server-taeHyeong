package pard.assignment4.dto.user.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pard.assignment4.entity.user.User;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserCreateRequest {
    private String name;
    private String address;

    public User toEntity() {
        return User.builder().name(name).address(address).build();
    }
}

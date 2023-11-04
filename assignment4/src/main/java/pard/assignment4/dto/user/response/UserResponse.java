package pard.assignment4.dto.user.response;

import pard.assignment4.entity.user.User;

public class UserResponse {
    private Long id;
    private String name;
    private String address;

    public UserResponse(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.address = user.getAddress();
    }
}

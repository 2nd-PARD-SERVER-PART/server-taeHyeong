package pard.assignment4.controller.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pard.assignment4.dto.user.request.UserCreateRequest;
import pard.assignment4.dto.user.request.UserUpdateRequest;
import pard.assignment4.dto.user.response.UserResponse;
import pard.assignment4.entity.user.User;
import pard.assignment4.service.user.UserService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody UserCreateRequest request){
        User createdUser = userService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createdUser);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> findAllUsers() {
        List<UserResponse> users = userService.findAll()
                .stream()
                .map(UserResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(users);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserResponse> findUser(@PathVariable Long userId) {
        User user = userService.findById(userId);

        return ResponseEntity.ok()
                .body(new UserResponse(user));
    }

    @PatchMapping("/user/{userId}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long userId, @RequestBody UserUpdateRequest request) {
        User updatedUser = userService.updateUser(userId, request);

        return ResponseEntity.ok()
                .body(new UserResponse(updatedUser));
    }


    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);

        return ResponseEntity.noContent()
                .build();
    }
}

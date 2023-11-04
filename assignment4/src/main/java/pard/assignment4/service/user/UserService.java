package pard.assignment4.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pard.assignment4.dto.user.request.UserCreateRequest;
import pard.assignment4.dto.user.request.UserUpdateRequest;
import pard.assignment4.dto.user.response.UserResponse;
import pard.assignment4.entity.user.User;
import pard.assignment4.repository.user.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User save(UserCreateRequest request) {
        return userRepository.save(request.toEntity());
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("사용자가 존재하지 않습니다."));
    }

    public User updateUser(Long userId, UserUpdateRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("사용자가 존재하지 않습니다."));
        user.update(request.getName(), request.getAddress());

        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

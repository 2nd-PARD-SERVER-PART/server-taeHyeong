package pard.assignment4.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import pard.assignment4.entity.user.User;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);
}

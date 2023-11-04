package protect.pard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import protect.pard.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {
}

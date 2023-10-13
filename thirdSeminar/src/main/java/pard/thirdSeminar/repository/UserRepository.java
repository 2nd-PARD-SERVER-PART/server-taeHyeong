package pard.thirdSeminar.repository;

import jdk.dynalink.linker.LinkerServices;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pard.thirdSeminar.entity.UserEntity;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    boolean existsByUserEmail(String userEmail);
    boolean existsByUserEmailAndUserPassword(String userEmail, String userPassword);
    //List<UserEntity> findByUserSignUptimeOrdOrderByUserSignUptime;
}
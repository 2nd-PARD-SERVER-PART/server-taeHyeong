package pard.thirdSeminar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import pard.thirdSeminar.dto.SignUpDto;

import java.sql.Timestamp;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userNum;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String userEmail;
    @Column(length = 20)
    private String userPassword;
    @CreationTimestamp
    private Timestamp userSignUptime;

    public UserEntity(SignUpDto dto) {
        this.userEmail = dto.getUserEmail();
        this.userPassword = dto.getUserPassword();
    }
}

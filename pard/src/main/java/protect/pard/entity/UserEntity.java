package protect.pard.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import protect.pard.dto.SignUpDto;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
public class UserEntity {
    @Id
    private String userEmail;
    private String userPassword;

    public UserEntity(SignUpDto dto) {
        this.userEmail = dto.getUserEmail();
        this.userPassword = dto.getUserPassword();
    }
}

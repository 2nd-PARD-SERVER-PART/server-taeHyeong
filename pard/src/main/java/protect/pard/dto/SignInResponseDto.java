package protect.pard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import protect.pard.entity.UserEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInResponseDto {
    private String token;
    private int exprTime;
    private UserEntity userEntity;
}

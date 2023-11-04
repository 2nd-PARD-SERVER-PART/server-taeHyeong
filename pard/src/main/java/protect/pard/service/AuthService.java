package protect.pard.service;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import protect.pard.config.WebSecurityConfig;
import protect.pard.dto.ResponseDto;
import protect.pard.dto.SignInDto;
import protect.pard.dto.SignInResponseDto;
import protect.pard.dto.SignUpDto;
import protect.pard.entity.UserEntity;
import protect.pard.repository.UserRepository;
import protect.pard.security.TokenProvider;

@Service
public class AuthService {
    private UserRepository userRepository;
    private TokenProvider tokenProvider;
    private WebSecurityConfig webSecurityConfig;
    @Autowired
    public AuthService(UserRepository userRepository, TokenProvider tokenProvider, WebSecurityConfig webSecurityConfig) {
        this.userRepository= userRepository;
        this.tokenProvider = tokenProvider;
        this.webSecurityConfig = webSecurityConfig;
    }

    public ResponseDto<?> signUp(SignUpDto dto) {
        String userEmail = dto.getUserEmail();
        String userPassword = webSecurityConfig.getPasswordEncoder().encode(dto.getUserPassword());
        SignUpDto putDto = new SignUpDto(userEmail, userPassword);
        try {
            if(userRepository.existsById(userEmail)) {
                return ResponseDto.setFailed("이미 존재");
            }
        }catch (Exception e) {
            return ResponseDto.setFailed("DB error");
        }
        UserEntity userEntity = new UserEntity(putDto);

        userRepository.save(userEntity);

        return ResponseDto.setSuccess("Sign Up Success", userEntity);
    }

    public ResponseDto<SignInResponseDto> signIn(SignInDto dto) {
        String userEmail = dto.getUserEmail();
        UserEntity user = userRepository.findById(userEmail).get();
        boolean passwordMatch = webSecurityConfig.getPasswordEncoder().matches(dto.getUserPassword(), user.getUserPassword());
        boolean existed = userRepository.existsById(userEmail) && passwordMatch;
        if(!existed) return ResponseDto.setFailed("이메일이나 비번 틀림");
        user.setUserPassword("");

        String token = tokenProvider.create(userEmail);
        int exprTime = 360000;

        SignInResponseDto signInResponseDto = new SignInResponseDto(token, exprTime, user);
        return ResponseDto.setSuccess("login success", signInResponseDto);
    }

}

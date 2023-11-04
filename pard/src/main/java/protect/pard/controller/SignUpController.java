package protect.pard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import protect.pard.dto.ResponseDto;
import protect.pard.dto.SignInDto;
import protect.pard.dto.SignInResponseDto;
import protect.pard.dto.SignUpDto;
import protect.pard.service.AuthService;

@RestController
@RequestMapping("/auth")
public class SignUpController {
    private AuthService authService;

    @Autowired
    public SignUpController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signUp")
    public ResponseDto<?> signUp(@RequestBody SignUpDto dto) {
        ResponseDto<?> result = authService.signUp(dto);
        return result;
    }

    @PostMapping("/signIn")
    public ResponseDto<SignInResponseDto> signIn(@RequestBody SignInDto signInDto) {
        ResponseDto<SignInResponseDto> result = authService.signIn(signInDto);
        return result;
    }
}

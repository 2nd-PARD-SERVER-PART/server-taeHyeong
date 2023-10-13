package pard.thirdSeminar.controller;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pard.thirdSeminar.dto.ResponseDto;
import pard.thirdSeminar.dto.SignInDto;
import pard.thirdSeminar.dto.SignUpDto;
import pard.thirdSeminar.entity.UserEntity;
import pard.thirdSeminar.service.UserService;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signUp")
    public ResponseDto<UserEntity> signUp(@RequestBody SignUpDto dto) {
        ResponseDto<UserEntity> result = userService.signUp(dto);
        return result;
    }
    @GetMapping("/findAll")
    public ResponseDto<List<UserEntity>> findAll() {
        ResponseDto<List<UserEntity>> result = userService.findAll();
        return  result;
    }

    @GetMapping("/findOne/{userNum}")
    public ResponseDto<UserEntity> findOne(@PathVariable Integer userNum) {
        ResponseDto<UserEntity> result = userService.findOne(userNum);
        return  result;
    }

    @PatchMapping("/update/{userNum}")
    public ResponseDto<UserEntity> update(@PathVariable Integer userNum, @RequestBody SignUpDto dto) {
        ResponseDto<UserEntity> result = userService.updateOne(userNum, dto);
        return result;
    }

    @DeleteMapping("/delete/{userNum}")
    public ResponseDto<?> delete(@PathVariable Integer userNum){
        ResponseDto<?> result = userService.delete(userNum);
        return result;
    }

    @PostMapping("/signIn")
    public ResponseDto<?> signIn(@RequestBody SignInDto dto){
        ResponseDto<?> result = userService.signIn(dto);
        return result;
    }
}

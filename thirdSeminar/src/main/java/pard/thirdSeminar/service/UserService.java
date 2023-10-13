package pard.thirdSeminar.service;

import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pard.thirdSeminar.dto.ResponseDto;
import pard.thirdSeminar.dto.SignInDto;
import pard.thirdSeminar.dto.SignUpDto;
import pard.thirdSeminar.entity.UserEntity;
import pard.thirdSeminar.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseDto<UserEntity> signUp(SignUpDto dto) {
        UserEntity user = new UserEntity(dto);
        try {
            if(userRepository.existsByUserEmail(dto.getUserEmail())){
                return ResponseDto.setFalse("이미 존재하는 아이디 입니다.");
            }
            userRepository.save(user);
            return ResponseDto.setSuccess("축하해", user);
        } catch(Exception e) {
            e.printStackTrace();
            return ResponseDto.setFalse("데이터베이스 오류");
        }
    }

    public ResponseDto<List<UserEntity>> findAll() {
        List<UserEntity> users;
        try {
            users = userRepository.findAll();
            return ResponseDto.setSuccess("find Success", users);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFalse("오류");
        }
    }

    public ResponseDto<UserEntity> findOne(Integer userNum) {
        UserEntity user;
        try{
            user = userRepository.findById(userNum).get();
            return ResponseDto.setSuccess("find One", user);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFalse("dd");
        }
    }

    @Transactional
    public ResponseDto<UserEntity> updateOne(Integer userNum, SignUpDto dto) {
        UserEntity user;
        try{
            user = userRepository.findById(userNum).get();
            if(dto.getUserEmail() != null && !dto.getUserEmail().isEmpty()) {
                user.setUserEmail(dto.getUserEmail());
            }
            if(dto.getUserPassword() != null && !dto.getUserPassword().isEmpty()) {
                user.setUserPassword(dto.getUserPassword());
            }
            return ResponseDto.setSuccess("find One", user);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFalse("dd");
        }
    }

    public ResponseDto<UserEntity> delete(Integer userNum) {
        try{
            if(userRepository.existsById(userNum)) {
                userRepository.deleteById(userNum);
            }
            return ResponseDto.setSuccess("Delete", null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFalse("dd");
        }
    }

    public ResponseDto<String> signIn(SignInDto dto){
        String userEmail = dto.getUserEmail();
        String userPassword = dto.getUserPassword();
        try{
            boolean existed = userRepository.existsByUserEmailAndUserPassword(userEmail, userPassword);
            if(!existed) return ResponseDto.setFalse("존재하지 않는 userEmail");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFalse("DB오류");
        }
        return  ResponseDto.setSuccess("로그인을 축하드립니다.", userEmail);
    }
}

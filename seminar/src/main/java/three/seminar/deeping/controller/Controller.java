package three.seminar.deeping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import three.seminar.deeping.repostory.UserRepository;
import three.seminar.deeping.user.User;

import java.util.List;

@RestController
@RequestMapping("/user")
public class Controller {
    private final UserRepository userRepository;
    @Autowired
    public Controller(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/add")
    public String userAdd(@RequestParam Integer stuNum, @RequestParam String stuName) {
        User user = new User();
        user.setStuNum(stuNum);
        user.setStuName(stuName);
        userRepository.save(user);
        return "버전 1";
    }

    @PostMapping("/add/{stuNum}/{stuName}")
    public String userAdd2(@PathVariable Integer stuNum, @PathVariable String stuName) {
        User user = new User();
        user.setStuNum(stuNum);
        user.setStuName(stuName);
        userRepository.save(user);
        return "버전 2";
    }

    @PostMapping("/add3")
    public String UserAdd(@RequestBody User user) {
        userRepository.save(user);
        return "버전 3";
    }

    @GetMapping("/findAll")
    public List<User> userFind() {
        List<User> hGUStudent = userRepository.findAll();
        return hGUStudent;
    }

    @GetMapping("/findOne/{stuNum}")
    public User userFindOne(@PathVariable Integer stuNum) {
        User user = userRepository.findById(stuNum);
        return user;
    }

    @PatchMapping("/update/{stuNum}")
    public String userUpdate(@PathVariable Integer stuNum, @RequestBody User user) {
        userRepository.update(stuNum, user);
        return "교체 완료";
    }

    @DeleteMapping("/delete/{stuNum}")
    public String userDelete(@PathVariable Integer stuNum) {
        userRepository.delete(stuNum);
        return "제거 완료";
    }
}

package three.seminar.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LogTestController {
    @RequestMapping("/log-test")
    public String logtest() {
        String name = "JtaeH";
        System.out.println("name = " + name);
        log.info("info log = {}", name);
        log.trace("info log = {}", name);
        log.debug("info log = {}", name);
        log.warn("info log = {}", name);
        log.error("info log = {}", name);
        log.info("Wrong log = " + name);
        return "okay";
    }
}

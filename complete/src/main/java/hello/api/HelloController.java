package hello.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String home() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/test")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
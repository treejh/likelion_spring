package restful실습.기본개념실습;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class HelloController {
    //@ResponseBody

    //@RestController = Controller + ResponseBody
    @GetMapping("/hello")
    public String hello(){

        return "안녕";
    }
}
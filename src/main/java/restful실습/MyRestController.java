package restful실습;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import restful실습.domain.User;

@RestController
public class MyRestController {

    @GetMapping("/api/greeting")
    public Map<String, String> greet
            (@RequestParam(name = "message",required = false, defaultValue = "hello")String message){
        Map<String, String> res = new HashMap<>();
        res.put("message",message);
        res.put("key","value");

        return res;
    }

    @GetMapping("/api/greeting/test")
    public Map<String, String> greetTest(){
        Map<String, String> res = new HashMap<>();
        res.put("message","kang");
        res.put("key","value");

        return res;
    }


    @GetMapping(value = "/api/user", produces = "application/json")
    public User getUser(@RequestParam(name="name")String name){
        return new User(name,"010-111-1111");
    }

    @GetMapping("/api/users")
    public List<User> getUsers(){

        return null;
    }
}
package springMVC.controller;


import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import springMVC.domain.Item;

@Controller
public class WelcomeController {
    @GetMapping("/welcome")
    public String welcome(Model model){
        model.addAttribute("welcomeMessage","안녕하세요, 반갑습니다. ");
        List<Item> itemList = Arrays.asList(
                new Item("apple",1.24),
                new Item("banana",3.44),
                new Item("Oragne",1.38)

        );
        model.addAttribute("items",itemList);
        return "welcome";

    }
}

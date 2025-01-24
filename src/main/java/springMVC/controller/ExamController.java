package springMVC.controller;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springMVC.domain.Item;
import springMVC.domain.UserForm;

@Controller
@RequestMapping("/exam")
public class ExamController {
    @GetMapping("/example")
    public String showExample(Model model){
        model.addAttribute("username", "carami");
        model.addAttribute("isAdmin", true);
        model.addAttribute("languages", new String[]{"English","Spanish","Korean"});
        model.addAttribute("item", new Item("pen",3.33));
        return "example";
    }


    @GetMapping("/dateTime")
    public String dateTime(Model model){
        model.addAttribute("currentDate", LocalDate.now());
        model.addAttribute("currentDateTime", LocalDateTime.now());
        model.addAttribute("currentTime", LocalTime.now());
        model.addAttribute("currentZonedDateTime", ZonedDateTime.now(ZoneId.of("Asia/Seoul")));
        return "datetime"; // Thymeleaf 템플릿 이름
    }


    @PostMapping("/submitForm")
    public String submitForm(@RequestParam("username") String username, @RequestParam("password") String password){
        System.out.println(username +"::::"+password);
        return "result";

    }

    @PostMapping()
    public String submitForm(@ModelAttribute("userForm") UserForm userFrom){
        System.out.println(userFrom);
        return "result";

    }

}
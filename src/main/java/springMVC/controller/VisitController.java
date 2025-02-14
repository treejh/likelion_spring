package springMVC.controller;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VisitController {

    @GetMapping("/visit")
    public String showVisit(
            @CookieValue(name="lastVisit",defaultValue = "N/A")String lastVisit,
            HttpServletResponse response, Model model){
        model.addAttribute("lastVisit",lastVisit);

        Cookie cookie = new Cookie("lastVisit","varami");
        return "visit";
    }
}

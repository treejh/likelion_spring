package springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class UserController {

    @ModelAttribute
    public void addAttribute(Model model){
        model.addAttribute("msg","환영합니다. ");

    }



}

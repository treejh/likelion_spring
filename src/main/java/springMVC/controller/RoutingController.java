package springMVC.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoutingController {

    @GetMapping("/start")
    public String startProcess(Model model){
        System.out.println("Start start!!!!!");
        model.addAttribute("forwardTest","jihyun");
        return "forward:/forward";
    }

    @GetMapping("/forward")
    public String forward(Model model, HttpServletRequest request){
        System.out.println("forward start!!!!");
        System.out.println("forwardTest ::::"+model.getAttribute("forwardTest"));
        System.out.println(request.getParameter("forwardTest"));
        return "forwardPage";
    }

    @GetMapping("/redirect")
    public String redirect(Model model){
        System.out.println("redirect start!!!!");
        model.addAttribute("redirectTest","jihyun Redirect");
        return "redirect:/finanlDestination";
    }

    @GetMapping("/finanlDestination")
    public String finalDestination(Model model,HttpServletRequest request){
        System.out.println("redirect start!!!!");
        System.out.println("redirectTest ::::"+model.getAttribute("forwardTest"));
        System.out.println(request.getParameter("redirectTest"));

        return "redirectPage";

    }
}

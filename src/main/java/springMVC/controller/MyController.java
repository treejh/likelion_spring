package springMVC.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/todo")
    @ResponseBody
    public String todo(){
        return "todo!!";
    }

    @GetMapping("/greeting")
    public ModelAndView greet(@RequestParam(name="name", required = false,defaultValue = "world") String name){
        ModelAndView mv = new ModelAndView("greetingPage");
        mv.addObject("name",name);
        return mv;
    }

    @GetMapping("/greeting2")
    public String greet2(@RequestParam(name="name", required = false,defaultValue = "world") String name
    , Model model){
        model.addAttribute("name",name);
        return "greetingPage";
    }

}

package springMVC.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/session")
@SessionAttributes("visitCount")
public class SessionController {


    @ModelAttribute("visitCount")
    public Integer initVisitCount(){
        return 0;
    }
    @GetMapping("/visit")
    public String visit(@ModelAttribute("visitCount")Integer visitCount, Model model){
        //HttpSession이 아닌 스프링 직접 이용
        visitCount++;
        model.addAttribute("VisitCount", visitCount);
        return "visitSession";
    }
//HTTP 세션에 직접 접근하는 방법
//    @GetMapping("/visit")
//    public String visit(HttpSession session, Model model){
//        //HttpSession 은 HttpServletRequest의 getSession() 메서드로 얻어올 수 있는데,
//        //getSession() 이라는 메서드는 세션이 이미 존재하면 있는것을 리턴해주고,
//        // 없다면 새로 생성해서 리턴 (세션객체를 생성하고, sessionId 를 발급받아서 쿠키로만들어
//        // response에 넣는 작업까지 실행된다.
//        Integer visitCount =  (Integer)session.getAttribute("visitCount");
//        if(visitCount == null){
//            visitCount = 0;
//        }
//        visitCount++;
//
//        session.setAttribute("visitCount", visitCount);
//        model.addAttribute("visitCount",visitCount);
//        return "visitSession";
//    }
//}

    //스프링 부트 세션 사용 : SessionStatus는 스프링부트가 제공하는 메서드
//    @GetMapping("/resetVisit")
//    public String resetSession(SessionStatus status){
//        status.setComplete(); @SessionAttributes("visitCount") 이렇게 등록된 값들만 삭제
//        return"redirect:/session/visit";
//    }



//세션 직접 사용
    @GetMapping("/resetVisit")
    public String resetVisit(HttpSession session){
        session.invalidate(); //세션 객체 삭제
//        session.removeAttribute("visitCount"); //특정 속성만 삭제
        return"redirect:/session/visit";
    }
}

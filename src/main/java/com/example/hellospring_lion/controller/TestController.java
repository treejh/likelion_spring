package com.example.hellospring_lion.controller;

import com.example.hellospring_lion.domain.User;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class TestController {
    @GetMapping("/users")
    public String getUsers(Model model) {
        Test test = new Test("test","testData111");

        model.addAttribute("test", test);
        // View 이름 반환
        return "users";  // users.html 파일을 렌더링
    }

}

package com.example.hellospring_lion;



import com.example.hellospring_lion.config.UserConfig;
import com.example.hellospring_lion.controller.UserController;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserExam {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(UserConfig.class);
        UserController controller = context.getBean(UserController.class);
        controller.joinUser();

        //이렇게 실행하면~~~    user+"의 정보가 잘 저장되었습니다."  이렇게 출력될 수 있도록!!!
        //Bean을 등록해 보세요.

    }


}

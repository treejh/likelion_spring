package com.example.hellospring_lion;

import com.example.hellospring_lion.config.UserConfig;
import com.example.hellospring_lion.controller.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class HelloSpringLionApplication implements CommandLineRunner {

    public static void main(String[] args) {
        ApplicationContext context =  SpringApplication.run(HelloSpringLionApplication.class, args);
//        UserController controller = context.getBean(UserController.class);
//        controller.joinUser();
    }

    @Autowired
    UserController userController;

    @Override
    public void run(String... args) throws Exception {
        userController.joinUser();
    }


}

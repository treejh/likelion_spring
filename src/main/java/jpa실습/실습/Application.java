package jpa실습.실습;

import jakarta.persistence.NamedStoredProcedureQueries;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class Application implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Autowired
    UserRepository userRepository;


    @Override
    public void run(String ...args){
        //userRepository.findAll().forEach(result -> log.info("이름 : "+ result.getName()));
//        List<User> user = userRepository.findUsersByName("h");
//        user.forEach(result ->log.info("이름 : "+ result.getName()));
//
//        //이메일로 조회
//        List<User> user = userRepository.findUsersByEmail("hong1@exam.com");
//        user.forEach(result ->log.info("이름 : {}  이메일 : {}",result.getName(),result.getEmail()));

        userRepository.findUsersDynamically("carami",null)
                .forEach(result -> log.info("user:: {} {}",result.getName(),result.getEmail()));


    }

}

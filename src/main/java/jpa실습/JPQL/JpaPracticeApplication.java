package jpa실습.JPQL;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@SpringBootApplication
@Slf4j
public class JpaPracticeApplication {
    public static void main(String[] args) {
        SpringApplication.run(JpaPracticeApplication.class, args);


    }

    @Bean
    public CommandLineRunner run(UserRepository repository){
        return args -> {
//            //create
//            User user = new User("hong","hong2@exam.com");
//            repository.save(user);
//            log.info("사용자 추가 : :"+user);

//            //update
//            User user = repository.findById(3L).get();
//            user.setName("test1");
//            user.setEmail("test1@xam.com");
//
//            repository.save(user);

//            //delete
//            User user = repository.findById(3L).get();
//            repository.delete(user);


//            //문자가 포함된 데이터 찾아오기
//            repository.findByNameContaining("hong")
//                    .forEach(user->log.info(user.toString()));


            int updateCount = repository.updateByEmail(4L,"updateHong@exam.com");
            log.info("count :: " +updateCount);

            Pageable pageable = PageRequest.of(1,2);

            repository.findByNameContaining("name",pageable).forEach(user -> log.info(user.getName()));
        };
    }
}

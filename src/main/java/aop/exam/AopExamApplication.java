package aop.exam;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopExamApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(AopExamApplication.class);

    }


    @Autowired
    private SimpleService simpleService;

    @Override
    public void run(String... args) throws Exception{
        System.out.println("SimpleService ");
        System.out.println(simpleService.doSomething());

        simpleService.hello();
        simpleService.getName();
        simpleService.setName("jang");
    }



}

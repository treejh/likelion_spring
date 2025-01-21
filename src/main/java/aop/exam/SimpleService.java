package aop.exam;


import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class SimpleService {
    public String doSomething(){
        System.out.println("simpleService doSomething구현 ");
        return "Doing Something";
    }

    public void hello(){
        System.out.println("hello() run..");
//        //예외추가
//        if(true){
//            throw  new RuntimeException();
//        }
    }

    public void setName(String name){
        System.out.println("setName() run ...");
    }

    public void getName(){
        System.out.println("getName() run...");
    }
}

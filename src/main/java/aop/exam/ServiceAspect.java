package aop.exam;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {

    @Before("execution(* aop.exam.SimpleService.*(..))")
    public void before(JoinPoint joinPoint){
        System.out.println("Before 실행됨!!:::::::::::::::::"+joinPoint.getSignature());
        //getSignature() -> 실제로 호출한 메서드
        //getSignature().getName() -> 실제로 호출한 메서드의 이름이 호출됨
    }


    @After("execution(* aop.exam.SimpleService.*(..))")
    public void after(JoinPoint joinPoint){
        System.out.println("After 실행됨!! :::::::::::::::" +joinPoint.getSignature());
        System.out.println("=====================");
    }

}

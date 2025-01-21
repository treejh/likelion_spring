package aop.exam;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {

    @Pointcut("execution(* aop.exam.SimpleService.*(..))")
    public void pc(){
    }

    @Pointcut("execution(* hello())")
    public void pcHello(){};


    @Before("pc()")
    public void test(JoinPoint joinPoint){
        System.out.println("PC Before 실행됨!!:::::::::::::::::"+joinPoint.getSignature());
        //getSignature() -> 실제로 호출한 메서드
        //getSignature().getName() -> 실제로 호출한 메서드의 이름이 호출됨
    }

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

    @After("pcHello()")
    public void test2(JoinPoint joinPoint){
        System.out.println("PC After 실행됨!!(hello만 실행!!)) :::::::::::::::" +joinPoint.getSignature());
        System.out.println("=====================");
    }

    @AfterReturning(pointcut = "pc()",returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){
        System.out.println("AfterReturning ::::::::: "+ joinPoint.getSignature().getName()+", return value  :: "+result );
    }

    //예외가 발생될대만 사용
    @AfterThrowing(value="pc()", throwing = "ex")
    public void afterThrowing(Throwable ex){
        System.out.println("AfterTHrowing!!!");
        System.out.println("Exception value ::" + ex);
    }

}

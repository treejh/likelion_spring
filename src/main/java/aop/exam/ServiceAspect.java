package aop.exam;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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

    @Around("pc()")
    public String around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("Around 사용 전 !!!!!!!!!!  실제 메서드 실행되기 전에 해야할일이 있다면 여기 !!! ");

        String value= (String)proceedingJoinPoint.proceed();//실제 Target의 메서드 호출
        System.out.println("Around 사용 후 !!!!!!!!!!  실제 메서드 후 실행된 후 해야할 일이 있다면 여기 !!! ");

        value = "Around Test 해봤다 !!! ";

        return value;



    }

}

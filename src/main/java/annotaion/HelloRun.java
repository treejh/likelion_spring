package annotaion;

import java.lang.reflect.Method;

public class HelloRun {
    public static void main(String[] args) {
        Hello hello = new Hello();


//        Method method = hello.getClass().getDeclaredAnnotations("print");
//
//        if(method.isAnnotationPresent(count100.class)){
//            for(int i=0;i<10;i++){
//                hello.print();
//            }
//        }


        hello.print();
    }
}

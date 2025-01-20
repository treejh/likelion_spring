package annotaion;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ServiceRun {
    public static void main(String[] args) {
//        Service.class.getDeclaredMethods();

        Service service = new Service();
        Method[] methods = service.getClass().getDeclaredMethods();
        for(Method method : methods){
            if(method.isAnnotationPresent(PrintAnnotation.class)){
                System.out.println("Method : [[" +method.getName()+"]]");

                PrintAnnotation printAnnotation = method.getAnnotation(PrintAnnotation.class);
                for(int i=0;i< printAnnotation.number();i++){
                    System.out.print(printAnnotation.value());
                }
                System.out.println();
            }
            try {
                method.invoke(service);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }


    }
}

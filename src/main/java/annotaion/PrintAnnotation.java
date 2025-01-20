package annotaion;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD) //어노테이션이 메서드에만 붙을 수 있도록 제한한다.
public @interface PrintAnnotation {
    String value() default "*";

    int number() default 5;
}

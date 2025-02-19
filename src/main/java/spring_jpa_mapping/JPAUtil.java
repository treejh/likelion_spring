package spring_jpa_mapping;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory emfInstance=
            Persistence.createEntityManagerFactory("UserPU");

    //java 어플리케이션이 종료될 때 자동으로 close() 메서드가 호출되도록 합니다.
    static {
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            if(emfInstance!=null){
                System.out.println("---emf close --");
                emfInstance.close();
            }
        }));
    }


    //생성자를 private로 만들면 본인만 쓸 수 있음, 다른 곳에서 선언 불가능
    private JPAUtil(){};

    public static EntityManagerFactory entityManagerFactory(){
        return emfInstance;
    }


}

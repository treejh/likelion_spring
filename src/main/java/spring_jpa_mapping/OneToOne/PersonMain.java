package spring_jpa_mapping.OneToOne;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import spring_jpa_mapping.JPAUtil;

@Slf4j
public class PersonMain {
    public static void main(String[] args) {
        find();
    }

    private static void find(){
        EntityManager em = JPAUtil.entityManagerFactory().createEntityManager();

        try{
            Passport passport = em.find(Passport.class,1L);
            log.info("여권 번호 : " + passport.getPassportNumber());

            Person person = passport.getPerson();
            log.info("여권 주인 : "+ person.getName());

        }finally {
            em.close();
        }
    }
}

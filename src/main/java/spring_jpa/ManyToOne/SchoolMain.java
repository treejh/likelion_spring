package spring_jpa.ManyToOne;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

import spring_jpa.JPAUtil;


@Slf4j
public class SchoolMain {
    public static void find() {
        EntityManager entityManager = JPAUtil.entityManagerFactory().createEntityManager();


        entityManager.getTransaction().begin();

        try{
            School school = entityManager.find(School.class,1L);

            log.info("School Name {}",school.getName() );

            for(Student student : school.getStudents()){
                System.out.println(student.getName());
            }
        }finally {
            entityManager.close();
        }
    }

    public static void create(){
        EntityManager entityManager = JPAUtil.entityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        try{
            School school = new School("lion school");

            Student student = new Student("장지현",school);

//            school.getStudents().add(student);
//            school.getStudents().add(new Student("장지현",school));
//            school.getStudents().add(new Student("권태윤",school));
//            school.getStudents().add(new Student("지드래곤",school));

            //관계 끊기
            school.getStudents().remove(student);


            entityManager.persist(school);

            entityManager.getTransaction().commit();


        }finally {
            entityManager.close();
        }

    }

    public static void main(String[] args) {
       find();

    }
}

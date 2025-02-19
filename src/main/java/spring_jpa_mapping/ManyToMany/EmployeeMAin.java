package spring_jpa_mapping.ManyToMany;


import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import spring_jpa_mapping.JPAUtil;

@Slf4j
public class EmployeeMAin {
    public static void main(String[] args) {
        //find();
        create();
        //update();
        //delete();
    }

    private static void find(){
        EntityManager em = JPAUtil.entityManagerFactory().createEntityManager();

        try{
            Project project = em.find(Project.class,1L);
            log.info("프로젝트 이름 " + project.getTitle());

            for(Employee employee : project.getEmployees()){
                log.info("직원 이름 : " + employee.getName());
            }
        }finally {
            em.close();
        }
    }


    private static void create(){
        EntityManager em = JPAUtil.entityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            //이렇게 하면, 직원을 사용해서 프로젝트를 올릴 수 있고, 프로젝트를 사용해서 ㅣ직원을 직원 테이블에 추가할 수 있다.
            Employee employee = new Employee("JihyunTestData");

            Project project = new Project();
            project.setTitle("testData");

            employee.getProjectList().add(project);
            project.getEmployees().add(employee);
            em.persist(employee);
            em.persist(project);


            //영속 상태로 올려주기만 하면, 프로젝트를 통해서 직원을 추가할수도 있다.

            //            Employee employee = new Employee("testJihyun");
            //            em.find(Project.class,1L).getEmployees().add(employee);
            //
            //
            //            em.persist(employee);
            //
            //            em.getTransaction().commit();

            em.getTransaction().commit();

        }catch (Exception e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
        }finally {
            em.close();
        }
    }
    private static void update(){
        EntityManager em = JPAUtil.entityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            Employee testEm = em.find(Employee.class,2L); //카라미 스미스


            testEm.getProjectList().add(em.find(Project.class,2L));

            em.persist(testEm);
            em.getTransaction().commit();


        }finally {
            em.close();
        }
    }

    private static void delete(){
        EntityManager em = JPAUtil.entityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            Employee employee = em.find(Employee.class,1L);


            em.remove(employee);

            em.getTransaction().commit();


        }finally {
            em.close();
        }
    }


}

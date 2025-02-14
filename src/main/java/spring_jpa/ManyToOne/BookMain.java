package spring_jpa.ManyToOne;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import spring_jpa.JPAUtil;


@Slf4j
public class BookMain {

    public static void main(String[] args) {
        find();
    }

    private static void find(){
        EntityManager em = JPAUtil.entityManagerFactory().createEntityManager();
        em.getTransaction().begin();

        try{
//            Author author = em.find(Author.class,1L);
//            log.info("지은이 이름 : "+ author.getName());
//
//            for(Book book : author.getBookList()){
//                log.info("책 제목 " + book.getTitle());
//            }
//            Book book = em.find(Book.class,1L);
//            log.info("BookTitle : "+ book.getTitle());
//            log.info("Author name : " + book.getAuthor().getName());

            Author author = em.find(Author.class,3L);
            em.remove(author);
            em.getTransaction().commit();
//

        }finally {
            em.close();
        }
    }


    private static void remove(){
        EntityManager em = JPAUtil.entityManagerFactory().createEntityManager();
//        em.getTransaction().begin();

        try{
//            Author author = em.find(Author.class,1L);
//            log.info("지은이 이름 : "+ author.getName());
//
//            for(Book book : author.getBookList()){
//                log.info("책 제목 " + book.getTitle());
//            }
            Book book = em.find(Book.class,1L);
            Author author = em.find(Author.class,1L);
            author.getBookList().clear();
            em.remove(author);

        }finally {
            em.close();
        }
    }
}

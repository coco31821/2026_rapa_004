import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.s02.Post;

public class EntityMangerTest1 {

    private static final EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("hibernate-exp-4");
    }

    void main(){

        // Persistence Context, fist lv cche

        EntityManager em = emf.createEntityManager();
        // thread-safe하지 않음.
        // tomcat 요청하나당 thread 하나
        // 하나 작업당 entitymanager 하나



        // EntityManager를 통해 transaction 만듦.
        // 바로 트랜잭션 실행되냐? 아님
        EntityTransaction tx = em.getTransaction();

        try{

            tx.begin();

            // Transient
            Post post = new Post(1, "title", "contents");

            // Managed -> Insert Into
            em.persist(post);


            tx.commit();


        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();

        } finally {
            // 기능 하나당 하나만 써야하므로
            em.close();
        }
        // application자체가 닫힌다
        emf.close();

    }

}

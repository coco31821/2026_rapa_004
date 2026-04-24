import jakarta.persistence.*;
import model.s03.Member;
import model.s03.Order;
import model.s03.OrderItem;
import model.s03.Product;

import java.util.List;

public class JpqlTests {

    // JPQL(Java Persistence Query Language)
    // 특정 데이터베이스에 종속되지 않는 객체지향 쿼리 언어
    // SQL이랑 유사하지만 테이블 대신 엔티티이름으로 쿼리를 작성

    void main(){


        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-exp-6");

        setup(emf);

       // jpql_basic_select_test(emf);
        jpql_where_condition_test(emf);

        tearDown(emf);
    }

    void setup(EntityManagerFactory emf){

        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();

        try{
            tx.begin();

            Member m1 = new Member("오지원","pass1","ojiwon@chicken.com");
            Member m2 = new Member("베라자","pass1","beraja@chicken.com");
//            Member m3 = new Member("문현민","pass1","mhm@chicken.com");

            Product p1 = new Product("나무배트", 150000, 50);
            Product p2 = new Product("가죽글러브", 50000, 10);

            Order o1 = new Order(m1);
            OrderItem oi1 = new OrderItem(p1, 1);
            OrderItem oi2 = new OrderItem(p2, 1);


            entityManager.persist(m1);
            entityManager.persist(m2);
//            entityManager.persist(m3);

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
            throw new RuntimeException(e);
        } finally {
            entityManager.close();
        }

    }

    void tearDown(EntityManagerFactory emf){
        emf.close();
    }

    void jpql_basic_select_test(EntityManagerFactory emf){

        EntityManager entityManager = emf.createEntityManager();

        /*
        SELECT
            m.id,
            m.name,
            m.password,
            m.email,
            ...
        FROM
            member m
         */
        String jpql = "SELECT m.address  FROM Member m";    // 객체 중심으로 query 구성



        // 객체 중심으로 쿼리를 만드는느낌이야
        // QueryDSL 동적 jpa query를 쉽게 써주는 도구. 그냥 jpa query 빡세게 하고 ㄱㄱ


        Query query = entityManager.createQuery(jpql, Member.class);// 하이라이팅 해줌 굿


        // 실제로 반환될때는 object로 반환. 이유는 범용적인 메서드기 때문에. 쿼리를 만들 떄 나 이 객체로 반화할거임! 하고 볼 수 이썩

//        Member singleResult =  query.getSingleResult(query);
        List<Member> members = query.getResultList();

        System.out.println("조회된 회원 수 : " + members.size());

        members.forEach(m-> System.out.println("회원 이름: "+m.getName()));


    }


    void jpql_where_condition_test(EntityManagerFactory emf){
        // test별로 의존해야 하는 데이터는 생성해서 받아야하는구나! 실제로는 entitymanager를 반복문으로 집어넣어줘야하는게 더 어울림.

        EntityManager entityManager = emf.createEntityManager();

        String jpql = """
        select
            m
        from
            Member m
                 
        """;

        Member findMember = entityManager.createQuery(jpql, Member.class)
                .getSingleResult();

        System.out.println("findMember = " + findMember);


    }


    void jpql_named_parameter_test(EntityManagerFactory emf){
        EntityManager entityManager = emf.createEntityManager();

        String jpql = """
        select
            m
        from
            Member m
        where
            m.email = :email
        """;
        // 실제 발생쿼리 주석

        TypedQuery<Member> query = entityManager.createQuery(jpql, Member.class);   // = jdbc의 ps

        query.setParameter("email","mhm@chicken.com");


    }

    void jpql_position_parameter_test(EntityManagerFactory emf){
        EntityManager entityManager = emf.createEntityManager();

        String jpql = """
        select
            m
        from
            Member m
        where
            m.email = ?1
        """;
        // 실제 발생쿼리 주석

        TypedQuery<Member> query = entityManager.createQuery(jpql, Member.class);   // = jdbc의 ps

        query.setParameter(1,"mhm@chicken.com");

        Member findMember = query.getSingleResult();
        System.out.println("findMember = " + findMember);

        entityManager.close();

    }

}

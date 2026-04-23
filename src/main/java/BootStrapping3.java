import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernatePersistenceConfiguration;

public class BootStrapping3 {

    //이번에는 jpa spec말고 hibernate spec을 따라가자는 거임
    // 이를 이용해서 초기화


    void main(){


        HibernatePersistenceConfiguration cfg =
                new HibernatePersistenceConfiguration("hibernate-exp")
                        .jdbcDriver("org.h2.Driver")
                        .jdbcUrl("jdbc:h2:mem:test-db")
                        .jdbcUsername("sa")
                        .jdbcPassword("");

        SessionFactory emf = cfg.createEntityManagerFactory();


    }

}


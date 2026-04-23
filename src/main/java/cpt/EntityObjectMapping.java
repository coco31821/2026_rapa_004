package cpt;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/*
    jpa가 어떤 컨셉을 가지고 sql과 mapping하는지 확인해보는 코드
 */

/*
*   @Entity annotation을 붙임으로써 entity객체임을 인지함.
*       - 영속성 컨텍스트로 관리되므로, 이를 식별하는 식별 필드가 필요하다
*           - @ID annotation이 붙은 field가 무조건 필요하다
*
*
*
* */


@Entity
public class EntityObjectMapping {


    @Id
    private String id;

    private String name;
    // ㄴ 이 친구를 테이블안에 있는 컬럼으로 읽었다


    // entity로 가진 애는 기본생성자를 가져야함.
    protected EntityObjectMapping() {}

    // 사용자 정의 생성자가 있으면, 컴파일러가 이를 기본 생성자로 생각하고 아무것도 없는 기본 생성자를 만들지 않는다.


    // 사용자 정의 생성자
    public EntityObjectMapping(String name) {
        this.name = name;
    }

    // 모든 필드에 대해 getter는 허용, id에 대해 setter 닫는 게 관례
    // 혹시나 id가 변경되면 비지니시 로직 터질 수 잇어서 ㅇㅇ;




    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}



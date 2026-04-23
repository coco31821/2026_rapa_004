package cpt;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class ColumnAndGeneration {

    // create table products( products_id bigint primary key );
    // 객체에 products_id ㅇㅈㄹ 할 수 없으니 @Column으로 mapping
    // ddl추측할때 @Column 이름으로 추측함. @Column 없으면 변수명 id이런걸로 추측함


    @Id
    @Column(name = "products_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;

    private String name;

    // ddl 추출할때 String은 보통 varchar(255)로 한다.
    // 너무 큼! columnDefinition을 통해 TEXT로 지정 가능
    // 이 속성은 ddl 추출할때(대신 만들어줄때) 쓰는거임. ddl-auto 안쓰면 안써도 됨.
    // 이 속성은 DB의 유효성 검사가 아님.
    @Column(columnDefinition = "TEXT")
    private String description;
}


// GeneratedValue 식별자 생성위임, 그걸 쓰겠다고 선언 => 이것두 ddl-auto
// GenerationType. identity / sequence / auto[기본값]
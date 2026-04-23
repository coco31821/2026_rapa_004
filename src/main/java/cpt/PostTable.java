package cpt;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// DB랑 어떻게 매핑되는지 알려주는 클래스
// postTable 테이블을 찾고, 그 다음은 post_table을 찾음
// @table로 매칭(아래선 article)
// db 복수 java entity 단수라서 그런거 맞추기도함
@Entity
@Table(name="article")
public class PostTable {

    @Id
    private Long id;

    private String title;
    private String contents;

}

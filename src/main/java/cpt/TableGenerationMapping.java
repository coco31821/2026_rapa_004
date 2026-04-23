package cpt;

import jakarta.persistence.*;

@Entity
@TableGenerator(
        name="SAMPLE_SEQ_TABLE_GENERATOR",
        table ="SAMPLE_SEQUENCE_CHEK",
        pkColumnName = "SAMPLE_ACCOUNT_SEQ",
        allocationSize = 1
)
public class TableGenerationMapping {

    @Id
    @GeneratedValue(
            strategy = GenerationType.TABLE,
            generator = "SAMPLE_SEQ_TABLE_GENERATOR"
    )
    private Long id;




}

// 어디 테이블에서 이 시퀀스를 관리하는지에대한 테이블을 받는다.
// sequence처럼 작동할 수 있다.

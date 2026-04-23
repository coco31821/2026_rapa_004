package cpt;


import jakarta.persistence.*;

/*
    Sequence가 어떻게 작동하는지 알아보는 코드
 */
@Entity
@SequenceGenerator(
        name="SAMPLE_SEQ_GENERATOR",
        sequenceName = "SAMPLE_SLQ",
        initialValue = 1,
        allocationSize = 1
)
public class SequenceMapping {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SAMPLE_SEQ_GENERATOR"
    )
    private Long id;

}

// SequenceGenerator 부여, generator 이름 SAMPLE_SEQ_GENERATOR, sequence이름 SAMPLE_SLQ
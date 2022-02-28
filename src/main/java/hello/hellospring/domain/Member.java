package hello.hellospring.domain;

import javax.persistence.*;

@Entity // JPA가 관리하는 Entity가 됨
public class Member {

    // Id = pk 지정
    // generatedvalue = db가 생성 identity
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

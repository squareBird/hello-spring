package hello.hellospring;

import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class springConfig {

    /*private DataSource dataSource;
    
    // dataSource는 application.properties에 설정해줘서 이미 만들어져있음
//    @Autowired 잘보면 얘는 생성자이므로 Autowired가 필요 없음
    public springConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }*/

    private EntityManager em;

    public springConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        // 스프링빈에 등록된걸 넣어줌
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JpaMemberRepository(em);
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JdbcMemberRepository(dataSource);
//        return new MemoryMemberRepository();
    }
}

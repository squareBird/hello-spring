package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Spring이 JpaRepository 상속하고 있는게 있으면 자동으로 Bean 등록해줌
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    // jpql -> select m from Member m where m.name = ?
    // 인터페이스 이름만으로 개발이 끝남 개사기;
    @Override
    Optional<Member> findByName(String name);
}

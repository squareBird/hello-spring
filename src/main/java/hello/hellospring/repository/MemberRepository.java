package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;


// 왜 인터페이스로 만드는가?
// 저장소는 메모리로 하거나 DB를 쓰거나 파일을 이용하는 방법이 있음
// 저장소가 해야하는 기능을 우선 정의 해두고
// 나중에 File이나 DB로 변경하면
// MemberRepository memberRepository = new DbMemberRepository 또는 new FileMemberRepository로 바꾸고
// DB나 파일이 데이터를 저장하는 방식에 따라 코드조금 수정해주면 됨
public interface MemberRepository {

    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();

}

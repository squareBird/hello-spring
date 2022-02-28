package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceIntTest {

    // @SpringBootTest 붙어있으면 springConfig도 같이 올라오니까 bean있음
    // Autowired로 그냥 넣어버림
    @Autowired MemberRepository memberRepository;
    @Autowired MemberService memberService;

    @Test
    void 회원가입() {

        // given
        Member member = new Member();
        member.setName("spring");

        // when : 뭘 검증할건지
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    @Test
    void 중복_회원예외() {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);
        // 람다식으로 표현
        // 뒤의 memberService.join(member2) 로직을 실행할 것인데
        // 앞의 illegalstateexception 예외가 터져야 한다는 것을 의미
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
/*
        memberService.join(member1);
        try {
            memberService.join(member2);
            fail("예외가 발생해야 합니다");
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }
*/


        // then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}
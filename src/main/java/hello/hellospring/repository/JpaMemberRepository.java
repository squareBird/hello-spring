package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

// jpa는 항상 트랜잭션 있어야 함
@Transactional
public class JpaMemberRepository implements MemberRepository {

    // gradle에서 jpa 추가해주면 entity매니저 자동 생성
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        // pk는 이렇게 간단하게 조회가능
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        // pk가 아니면 jpql 써야함
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class).
                setParameter("name", name).getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        // pk가 아니면 jpql 써야함
        List<Member> result = em.createQuery("select m from Member m", Member.class).
                getResultList();
        return result;

    }
}

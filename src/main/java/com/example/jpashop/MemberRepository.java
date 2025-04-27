package com.example.jpashop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em; // 엔티티 매니저 알아서 생성

    public Long save(Member member) {
        em.persist(member);
        return member.getId(); // id를 반환하는 이유 : 커맨드랑 쿼리를 분리해라
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }

}

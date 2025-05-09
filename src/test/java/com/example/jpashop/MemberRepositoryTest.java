package com.example.jpashop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

   @Test
   @Transactional
   @Rollback(false)
   public void testMember() throws Exception{
       // given
       Member member = new Member();
       member.setUsername("jaewoo");

       // when
       Long savedId = memberRepository.save(member);
       Member findMember = memberRepository.find(member.getId());

       // then
       Assertions.assertEquals(member.getId(), findMember.getId());
       Assertions.assertEquals(member.getUsername(), findMember.getUsername());
       Assertions.assertEquals(member, findMember);
   }
}
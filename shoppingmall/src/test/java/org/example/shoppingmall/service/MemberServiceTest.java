package org.example.shoppingmall.service;

import org.example.shoppingmall.entity.Member;
import org.example.shoppingmall.entity.MemberStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {
    @Autowired
    MemberService memberService;

    @Test
    public void addMember() {
        //given
        Member member = new Member(0,"test1","aaa","aaa","email1","01023322","중구 필동로", MemberStatus.A,null,null);
        //when
        memberService.addMember(member);
        List<Member> allMembers = memberService.getAllMembers();
        //then
        assertThat(allMembers.size()).isEqualTo(1);
    }

    @Test
    public void changePassword() {
        Member member = new Member(0,"test2","bbb","ccc","email","010233","중구 필동로", MemberStatus.A,null,null);
        int memberId = memberService.addMember(member);

        memberService.changePassword(memberId,"bbb","123");

        assertThat(memberService.getMemberById(memberId).getPassword()).isEqualTo("123");
    }

    @Test
    public void leaveProcess() {
        Member member = memberService.getMemberById(1);
        member.memberLeaveProcess();
        assertThat(member.getMemberStatus()).isEqualTo(MemberStatus.B);
        assertThat(member.getLeaveDate()).isEqualTo("2024-06-05");
    }

}
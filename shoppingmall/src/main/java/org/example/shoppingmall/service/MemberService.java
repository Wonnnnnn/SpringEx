package org.example.shoppingmall.service;

import lombok.RequiredArgsConstructor;
import org.example.shoppingmall.dto.MemberUpdateDTO;
import org.example.shoppingmall.entity.Member;
import org.example.shoppingmall.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member getMemberById(int id) {
        return memberRepository.findById(id).get();
    }

    @Transactional
    public int addMember(Member member) {
        return memberRepository.save(member).getMemeberId(); //장바구니 같이 만들어져야함
    }

    @Transactional
    public void updateMember(MemberUpdateDTO memberUpdateDTO) { //이름만 변경
        Member member = memberRepository.findById(memberUpdateDTO.getMemberId()).get();
        member.setMemeberName(memberUpdateDTO.getMemberName());
        //unique check
        member.setEmail(memberUpdateDTO.getEmail());
        member.setPhone(memberUpdateDTO.getPhone());
        member.setAddress(memberUpdateDTO.getAddress());
        memberRepository.save(member);
    }

    @Transactional
    public boolean changePassword(int memberId, String oldPassword, String newPassword) {
        Member member = memberRepository.findById(memberId).get();
        boolean result = member.changePassword(oldPassword, newPassword);

        if (result) { memberRepository.save(member); }

        return result;
    }
}

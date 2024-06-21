package org.example.shoppingmall.repository;

import org.example.shoppingmall.entity.Member;
import org.example.shoppingmall.entity.MemberStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    List<Member> findBymemberName(String memberName);
    List<Member> findByMemberStatus(MemberStatus memberStatus);
    Member findByEmail(String email);
    Member findByPhone(String phone);

}

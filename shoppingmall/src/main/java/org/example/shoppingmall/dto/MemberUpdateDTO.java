package org.example.shoppingmall.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.shoppingmall.entity.MemberStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberUpdateDTO {
    private int memberId;
    private String memberName;
    private String phone;
    private String email;
    private String address;
}

package org.example.shoppingmall.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memeberId;

    @Column(length = 20)
    private String memeberName;

    @Column(length = 6)
    private String userID;

    @Column(length = 8)
    private String password;

    @Column(length = 20, nullable = true, unique = true)
    private String email;

    @Column(length = 11, unique = true)
    private String phone;

    @Column(length = 20)
    private String address;

    @Enumerated(EnumType.STRING)
    private MemberStatus memberStatus;

    private LocalDate registerDate;
    private LocalDate leaveDate;

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMemeberName(String memeberName) {
        this.memeberName = memeberName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void memberLeaveProcess() {
        this.memberStatus = MemberStatus.B;
        this.leaveDate = LocalDate.now();
    }

     public boolean changePassword(String oldPassword, String newPassword) {
         if(this.password.equals(oldPassword)) {
             this.password = newPassword;
             return true;
         }
         return false;
     }
}

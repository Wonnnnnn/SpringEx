package org.example.empdept_mvc.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name="equipment")
@NoArgsConstructor
@AllArgsConstructor
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 10, unique = true)
    private String seqNo;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "equipment")
    private Employee employee;

    private int cost;
}

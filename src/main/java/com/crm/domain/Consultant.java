package com.crm.domain;

import com.crm.domain.Office;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Consultant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String phonenumber;
    private Boolean isActive;
    @ManyToOne
    @JoinColumn(name = "office_id")
    private Office office;
}

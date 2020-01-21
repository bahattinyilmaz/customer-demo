package com.crm.domain;

import com.crm.domain.Office;

import javax.persistence.*;

@Entity
public class Consultant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    @ManyToOne
    @JoinColumn(name = "office_id")
    private Office office;
}

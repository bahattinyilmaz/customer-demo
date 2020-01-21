package com.crm.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Town {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "province_id")
    private Province province;
}


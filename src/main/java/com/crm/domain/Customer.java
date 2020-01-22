package com.crm.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
@Data
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Customer{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String parentsName;
    private String parentsPhoneNumber;
    private Date conversationDate;
    private Date returnDate;
    private Date appointmentDate;
    private Date agreementDate;
    private String description;
    private String school;
    private String classes;
    private String education;
    private String result;

    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "salesChannel_id", referencedColumnName = "id")
    private SalesChannel salesChannel;

    private String price;
}

package com.crm.domain;

import com.crm.domain.Province;
import com.crm.domain.SalesChannel;
import com.crm.domain.Town;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
@Data
@Entity
public class Customer{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String parentsName;
    private String parentsPhoneNumber;
    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "province_id", referencedColumnName = "id")
    private Province province;
    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "town_id", referencedColumnName = "id")
    private Town town;
    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "consultant_id", referencedColumnName = "id")
    private Consultant consultant;
    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "salesChannel_id", referencedColumnName = "id")
    private SalesChannel salesChannel;
    private Date lastCallDate;
    private Boolean isAnAgreement;
    private String price;
    private Boolean isCallAgain;
}

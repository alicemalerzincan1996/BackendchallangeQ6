package com.company.repository.entity;

import com.company.enums.Meslek;
import lombok.*;
import lombok.experimental.SuperBuilder;


import javax.persistence.*;
import java.time.LocalDate;

@SuperBuilder //bir sınifta nesne uretmeyi saglar
@Data // get set metodlarini otomatik tanimlar
@NoArgsConstructor //Bos constructor
@AllArgsConstructor //dolu constructor
@ToString // tostring

@Entity
@Table(name = "tbluser")
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique = true)
    String username;

    String name;
    String surname;
    @Enumerated(EnumType.STRING)
    Meslek meslek;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id")
    Company company;


    LocalDate dogumtarihi;


}

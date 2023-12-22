package com.company.repository.entity;


import com.company.enums.Sektor;
import lombok.*;
import lombok.experimental.SuperBuilder;


import javax.persistence.*;
import java.util.List;

@SuperBuilder //bir sınifta nesne uretmeyi saglar
@Data // get set metodlarini otomatik tanimlar
@NoArgsConstructor //Bos constructor
@AllArgsConstructor //dolu constructor
@ToString // tostring

@Entity
@Table(name = "tblcompany")
public class Company extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique = true)
    String companyname;
    @Enumerated(EnumType.STRING)
    Sektor sektor;

}

package com.company.dto.request;

import com.company.repository.entity.Company;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Builder //bir sınifta nesne uretmeyi saglar
@Data // get set metodlarini otomatik tanimlar
@NoArgsConstructor //Bos constructor
@AllArgsConstructor //dolu constructor
@ToString // tostring


public class Companysavedto {
    String companyname;
}

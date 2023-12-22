package com.company.dto.request;

import lombok.*;

@Builder //bir sınifta nesne uretmeyi saglar
@Data // get set metodlarini otomatik tanimlar
@NoArgsConstructor //Bos constructor
@AllArgsConstructor //dolu constructor
@ToString // tostring


public class Companyupdatedto {
    String companyname;
}

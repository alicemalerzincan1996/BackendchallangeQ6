package com.company.dto.request;

import com.company.enums.Meslek;
import com.company.repository.entity.Company;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Builder // bir sınıftan nesne türetmeyi sağlar.
@Data //get set metodlarını otomatik tanımlar.
@NoArgsConstructor //boş constructor oluşturur.
@AllArgsConstructor //dolu constructor oluşturur.
public class UserupdateDto {
    @NotBlank(message = "Kullanıcı adı boş geçilemez.")
    @Size(min=3,max=30)
    String username;
    String name;
    String surname;


}

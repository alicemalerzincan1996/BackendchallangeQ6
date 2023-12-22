package com.company.service;

import com.company.enums.Meslek;
import com.company.enums.Sektor;
import com.company.repository.ICompanyRepository;
import com.company.repository.IUserRepository;
import com.company.repository.entity.Company;
import com.company.repository.entity.User;
import com.company.utility.ServiceManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class PostConstructs extends ServiceManager<Company,Long> implements Serializable {
    private final ICompanyRepository companyRepository;
    private final IUserRepository userRepository;
    private final CompanyService companyService;

    private final UserService userService;

    public PostConstructs(JpaRepository<Company, Long> repository, ICompanyRepository companyRepository, IUserRepository userRepository, CompanyService companyService, UserService userService) {
        super(repository);
        this.companyRepository = companyRepository;
        this.userRepository = userRepository;
        this.companyService = companyService;
        this.userService = userService;
    }
    @PostConstruct
    public void constructs(){
        if (companyRepository.findAll().size()>5) {}
        else {


        Company company=Company.builder().sektor(Sektor.Insaat).companyname("Erzincan insaat").build();
        companyService.save(company);
        Company company1=Company.builder().sektor(Sektor.Insaat).companyname("Mantik insaat").build();        companyService.save2(company1);


            Company compan2=Company.builder().sektor(Sektor.Lojistik).companyname("Erzurumlojistik").build();        companyService.save2(compan2);

            Company compan3=Company.builder().sektor(Sektor.Makine).companyname("Enefcon").build();        companyService.save2(compan3);

            Company compan4=Company.builder().sektor(Sektor.Makine).companyname("ELba").build();        companyService.save2(compan4);

            Company compan5=Company.builder().sektor(Sektor.Satis).companyname("Kardemir").build();        companyService.save2(compan5);





        User user=User.builder().username("Cemal1996").name("Cemal").
                surname("Erzincan").dogumtarihi(LocalDate.of(1996,3,30)).meslek(Meslek.Muhendis).company(company).build();

        User user1=User.builder().username("Murat1").name("Murat").
                surname("Gul").dogumtarihi(LocalDate.of(1976,3,12)).meslek(Meslek.Mimar).company(company).build();
        User user3=User.builder().username("Fatihx").name("Fatih").
                surname("Erzincanz").dogumtarihi(LocalDate.of(1996,3,30)).meslek(Meslek.Muhendis).company(compan4).build();
        User user1a=User.builder().username("cemx").name("cemmMurat").
                surname("Guler").dogumtarihi(LocalDate.of(1986,4,12)).meslek(Meslek.Usta).company(compan3).build();
        ArrayList<User>users=new ArrayList<>();
        userService.save2(user);
        userService.save2(user1);
        userService.save2(user3);
        userService.save2(user1a);




    }
    }
}

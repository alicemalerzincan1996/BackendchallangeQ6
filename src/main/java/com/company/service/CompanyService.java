package com.company.service;

import com.company.dto.request.Companysavedto;
import com.company.dto.request.Companyupdatedto;
import com.company.enums.Sektor;
import com.company.exception.CompanyException;
import com.company.exception.EerrorType;
import com.company.exception.UserException;
import com.company.repository.ICompanyRepository;
import com.company.repository.IUserRepository;
import com.company.repository.entity.Company;
import com.company.repository.entity.User;
import com.company.utility.ServiceManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService extends ServiceManager<Company,Long> implements Serializable {
    private final ICompanyRepository companyRepository;
    private final IUserRepository userRepository;
    public CompanyService(JpaRepository<Company, Long> repository, ICompanyRepository companyRepository, IUserRepository userRepository) {
        super(repository);

        this.companyRepository = companyRepository;
        this.userRepository = userRepository;
    }
    public Company save(Companysavedto companysavedto, Sektor sektor){
        Optional<Company> company1= companyRepository.findOptionalByCompanyname(companysavedto.getCompanyname());

        if (company1.isPresent())throw new CompanyException(EerrorType.Company_BULUNAMADI);
        Company company=Company.builder().companyname(companysavedto.getCompanyname()).sektor(sektor).build();
        return save(company);
    }
    public Company findbycompanyname(String companyname){
        Optional<Company> company=companyRepository.findOptionalByCompanyname(companyname);
        if (company.isPresent()) return company.get();
        else throw new CompanyException(EerrorType.Company_BULUNAMADI);

    }
    public Company findbyid(Long id){
        Optional<Company> company=companyRepository.findById(id);
        if (company.isPresent()) return company.get();
        else throw new CompanyException(EerrorType.Company_BULUNAMADI);

    }

    public String delete(Long id){
        Optional<Company> company =findById(id);
        if (company.isPresent()){
            List<User>users=userRepository.findAll();
            List<User> users1 = users.stream()
                    .filter(user -> user.getCompany() != null && user.getCompany().equals(company.get()))
                    .toList();
            users1.stream().forEach(a->a.setCompany(null));
            userRepository.saveAll(users1);

            deleteById(id);
            return "Silme basarili";
        }
        else throw new CompanyException(EerrorType.Company_BULUNAMADI);
    }

    public Company update(Companyupdatedto companyupdatedto,Long id,Sektor sektor){
        Optional<Company>company=companyRepository.findById(id);
        if (company.isPresent()){
            Company company1=company.get();
            company1.setCompanyname(companyupdatedto.getCompanyname());
            company1.setSektor(sektor);
           return update(company1);
        }else throw new CompanyException(EerrorType.Company_BULUNAMADI);
    }

    public User addemployer(Long companyid, Long userid){
        Optional<Company>company=companyRepository.findById(companyid);
        if (company.isPresent()){
            Company company1=company.get();
            Optional<User>user=userRepository.findById(userid);
            if (user.isPresent()){
                User user1=user.get();
                user1.setCompany(company1);
                return userRepository.save(user1);
            }else throw new UserException(EerrorType.User_BULUNAMADI);


        }else throw new CompanyException(EerrorType.Company_BULUNAMADI);

    }

    public List<Company> findall(){
        return companyRepository.findAll();
    }

}

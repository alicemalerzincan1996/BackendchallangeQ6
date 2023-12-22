package com.company.controller;

import com.company.dto.request.Companysavedto;
import com.company.dto.request.Companyupdatedto;
import com.company.enums.Sektor;
import com.company.repository.entity.Company;
import com.company.repository.entity.User;
import com.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.company.constants.EndPoints.*;
import static com.company.constants.EndPoints.DELETE;

@RestController
@RequestMapping(COMPANY)
public class CompanyController {
    private final CompanyService companyService;
    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping(SAVE)
    public ResponseEntity<Company> save (@RequestBody Companysavedto companysavedtosaveDto, @RequestParam Sektor sektor){
        return ResponseEntity.ok(companyService.save(companysavedtosaveDto,sektor));
    }
    @PutMapping(UPDATE)
    public ResponseEntity<Company> update (@RequestParam Long id, @RequestBody Companyupdatedto dto, @RequestParam Sektor sektor){
        return ResponseEntity.ok(companyService.update(dto,id,sektor));
    }
    @DeleteMapping(DELETE)
    public String deletebyid(@RequestParam Long id){
        return companyService.delete(id);
    }

    @GetMapping("/findbyidcompany")
    public ResponseEntity<Company> findbyid(@RequestParam Long id){
        return ResponseEntity.ok(companyService.findbyid(id));
    }
    @PostMapping("/addemployer")
    public ResponseEntity<User> addemployer(@RequestParam Long companyid,@RequestParam Long userid){
        return ResponseEntity.ok(companyService.addemployer(companyid,userid));
    }
    @GetMapping("/findbycompanyname")
    public ResponseEntity<Company> findbycompanyname(@RequestParam String companyname){
        return ResponseEntity.ok(companyService.findbycompanyname(companyname));
    }
    @GetMapping("/findall")
    public ResponseEntity<List<Company>> findall(){
        return ResponseEntity.ok(companyService.findall());
    }

}

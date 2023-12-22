package com.company.controller;

import com.company.dto.request.UsersaveDto;
import com.company.dto.request.UserupdateDto;
import com.company.enums.Meslek;
import com.company.repository.entity.User;
import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.company.constants.EndPoints.*;

@RestController
@RequestMapping(USER)

public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(SAVE)
    public ResponseEntity<User> save (@RequestBody UsersaveDto usersaveDto, @RequestParam Meslek meslek){
        return ResponseEntity.ok(userService.save(usersaveDto,meslek));
    }
    @PutMapping(UPDATE)
    public ResponseEntity<User> update (@RequestParam Long id, @RequestBody UserupdateDto dto,@RequestParam Meslek meslek){
        return ResponseEntity.ok(userService.update(id,dto,meslek));
    }

    @PutMapping("/leavework")
    public ResponseEntity<User> leavework (@RequestParam Long id){
        return ResponseEntity.ok(userService.leavework(id));
    }
    @DeleteMapping(DELETE)
    public String deletebyid(@RequestParam Long id){
        return userService.deletebyid(id);
    }



    @GetMapping("/findbyiduser")
    public ResponseEntity<User> findbyid(@RequestParam Long id){
        return ResponseEntity.ok(userService.findbyid(id));
    }
    @GetMapping("/findbyusername")
    public ResponseEntity<User> findbyusername(@RequestParam String username){
        return ResponseEntity.ok(userService.findbyUsername(username));
    }
    @GetMapping("/findall")
    public ResponseEntity<List<User>> findall(){
        return ResponseEntity.ok(userService.findall());
    }

}

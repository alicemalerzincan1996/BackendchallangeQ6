package com.company.service;
import com.company.dto.request.UsersaveDto;


import com.company.dto.request.UserupdateDto;
import com.company.enums.Meslek;
import com.company.exception.EerrorType;
import com.company.exception.UserException;
import com.company.mapper.IUserMapper;
import com.company.repository.IUserRepository;
import com.company.repository.entity.User;

import com.company.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserService extends ServiceManager<User,Long> implements Serializable {
   private final IUserRepository userProfileRepository;




    public UserService(IUserRepository userProfileRepository){
        super(userProfileRepository);
        this.userProfileRepository=userProfileRepository;


    }


    public User save(UsersaveDto usersaveDto, Meslek meslek){
        Optional<User> userx=userProfileRepository.findOptionalByUsername(usersaveDto.getUsername());
        if (userx.isPresent()) throw new UserException(EerrorType.User_Usernamekulaniliyor);

        User user= IUserMapper.INSTANCE.touser(usersaveDto);
        user.setMeslek(meslek);


        return save(user);

    }

    public String delete(Long id){
        Optional<User> user =findById(id);
        if (user.isPresent()){
            deleteById(id);
            return "Silme basarili";
        }
        else throw new UserException(EerrorType.User_BULUNAMADI);
    }

    public boolean savealluser(List<User> userList){
        userProfileRepository.saveAll(userList);
        return true;
    }

    public User update(Long id, UserupdateDto dto,Meslek meslek){
        Optional<User> user=findById(id);
        if (user.isPresent()){
            User user1=user.get();
            user1.setName(dto.getName());
            user1.setSurname(dto.getSurname());
            user1.setMeslek(meslek);
            user1.setUsername(dto.getUsername());
          return   update(user1);

        }
        else throw new UserException(EerrorType.User_BULUNAMADI);
    }

    public List<User> alluser(Long id){
        return findAll();
    }
    public User findbyid(Long id){
       Optional<User> user= findById(id);
       if (user.isPresent()){
           return user.get();
       }else throw new UserException(EerrorType.User_BULUNAMADI);
    }

    public User findbyUsername(String username){
        Optional<User> user=userProfileRepository.findOptionalByUsername(username);
        if (user.isPresent()){
            return user.get();
        }else throw new UserException(EerrorType.User_BULUNAMADI);
    }

    public List<User> findall(){
       return userProfileRepository.findAll();
    }

    public String deletebyid(Long id){
        Optional<User> user= findById(id);
        if (user.isPresent()){
            userProfileRepository.deleteById(id);
            return user.get().getName()+" silindi";
        }else throw new UserException(EerrorType.User_BULUNAMADI);
    }

    public User leavework(Long id){
        Optional<User> user= findById(id);
        if (user.isPresent()){
            User user1=user.get();
            user1.setCompany(null);
            return save(user1);


        }else throw new UserException(EerrorType.User_BULUNAMADI);
    };

    public User save2(User user){
        Optional<User> userx=userProfileRepository.findOptionalByUsername(user.getUsername());
        if (!userx.isPresent()) {




        return save(user);

    }
        return null;
    }












}


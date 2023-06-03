package com.example.VaccifyMe.service.impl;

import com.example.VaccifyMe.dao.UserRepository;
import com.example.VaccifyMe.dto.RequestDTO.UserRequestDto;
import com.example.VaccifyMe.dto.ResponseDTO.UserResponseDto;
import com.example.VaccifyMe.dto.ResponseDTO.StatusResponseDto;
import com.example.VaccifyMe.model.User;
import com.example.VaccifyMe.service.UserService;
import com.example.VaccifyMe.transformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserResponseDto addUser(UserRequestDto userRequestDto) {
        // Convert RequestDTO to Entity

//        User user = new User();
//        user.setName(userRequestDto.getName());
//        user.setAge(userRequestDto.getAge());
//        user.setEmailId(userRequestDto.getEmailId());
//        user.setGender(userRequestDto.getGender());
//        user.setMobNo(userRequestDto.getMobNo());

        User user = UserTransformer.UserRequestDtoToUser(userRequestDto);

        //save the object in db
        User savedUser = userRepository.save(user);

        //convert saved user to ResponseDTO
//        UserResponseDto userResponseDto = new UserResponseDto();
//        userResponseDto.setName(savedUser.getName());
//        userResponseDto.setMessage("Congrats!! you've successfully registered at VaccifyMe");

        UserResponseDto userResponseDto = UserTransformer.UserToUserResponseDto(savedUser);

        return userResponseDto;
    }

    @Override
    public UserResponseDto findByEmail(String emailId) {
        User user = userRepository.findByEmailId(emailId);
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setName(user.getName());
        userResponseDto.setMessage(user.getName() +" is registered for " +emailId + " emailId");
        return userResponseDto;
    }

    @Override
    public int updateName(String mobNo, String name) {
        int user = userRepository.updateName(mobNo, name);
        return user;
    }

    @Override
    public List<StatusResponseDto> notTakenSingleVaccine() {
        List<User> users = userRepository.notTakenSingleVaccine();
        List<StatusResponseDto> list = new ArrayList<>();
        for(User u : users){
            StatusResponseDto fullyUnvaccinatedResponseDto  = new StatusResponseDto();
            fullyUnvaccinatedResponseDto.setName(u.getName());
            fullyUnvaccinatedResponseDto.setEmailId(u.getEmailId());
            fullyUnvaccinatedResponseDto.setAge(u.getAge());
            fullyUnvaccinatedResponseDto.setGender(u.getGender());
            fullyUnvaccinatedResponseDto.setMobNo(u.getMobNo());

            list.add(fullyUnvaccinatedResponseDto);
        }
        return list;

    }

    @Override
    public List<StatusResponseDto> notTakenDose2() {
        List<User> users = userRepository.notTakenDose2();
        List<StatusResponseDto> list = new ArrayList<>();
        for(User u : users){
            StatusResponseDto fullyUnvaccinatedResponseDto  = new StatusResponseDto();
            fullyUnvaccinatedResponseDto.setName(u.getName());
            fullyUnvaccinatedResponseDto.setEmailId(u.getEmailId());
            fullyUnvaccinatedResponseDto.setAge(u.getAge());
            fullyUnvaccinatedResponseDto.setGender(u.getGender());
            fullyUnvaccinatedResponseDto.setMobNo(u.getMobNo());

            list.add(fullyUnvaccinatedResponseDto);
        }
        return list;
    }

    @Override
    public List<StatusResponseDto> fullyVaccinated() {
        List<User> users = userRepository.fullyVaccinated();
        List<StatusResponseDto> list = new ArrayList<>();
        for(User u : users){
            StatusResponseDto fullyvaccinatedResponseDto  = new StatusResponseDto();
            fullyvaccinatedResponseDto.setName(u.getName());
            fullyvaccinatedResponseDto.setEmailId(u.getEmailId());
            fullyvaccinatedResponseDto.setAge(u.getAge());
            fullyvaccinatedResponseDto.setGender(u.getGender());
            fullyvaccinatedResponseDto.setMobNo(u.getMobNo());

            list.add(fullyvaccinatedResponseDto);
        }
        return list;
    }

    @Override
    public List<StatusResponseDto> fullyUnvaccinatedMales() {
        List<User> users = userRepository.fullyUnvaccinatedMales();
        List<StatusResponseDto> list = new ArrayList<>();
        for(User u : users){
            StatusResponseDto fullyUnvaccinatedMalesResponseDto  = new StatusResponseDto();
            fullyUnvaccinatedMalesResponseDto.setName(u.getName());
            fullyUnvaccinatedMalesResponseDto.setAge(u.getAge());
            fullyUnvaccinatedMalesResponseDto.setGender(u.getGender());
            fullyUnvaccinatedMalesResponseDto.setMobNo(u.getMobNo());

            list.add(fullyUnvaccinatedMalesResponseDto);
        }
        return list;
    }

    @Override
    public List<StatusResponseDto> fullyVaccinatedFemales() {
        List<User> users = userRepository.fullyVaccinatedFemales();
        List<StatusResponseDto> list = new ArrayList<>();
        for(User u : users){
            StatusResponseDto fullyUnvaccinatedMalesResponseDto  = new StatusResponseDto();
            fullyUnvaccinatedMalesResponseDto.setName(u.getName());
            fullyUnvaccinatedMalesResponseDto.setAge(u.getAge());
            fullyUnvaccinatedMalesResponseDto.setGender(u.getGender());
            fullyUnvaccinatedMalesResponseDto.setMobNo(u.getMobNo());

            list.add(fullyUnvaccinatedMalesResponseDto);
        }
        return list;
    }

}

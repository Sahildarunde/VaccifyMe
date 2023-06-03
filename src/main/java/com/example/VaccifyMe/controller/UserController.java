package com.example.VaccifyMe.controller;

import com.example.VaccifyMe.dto.RequestDTO.UserRequestDto;
import com.example.VaccifyMe.dto.ResponseDTO.UserResponseDto;
import com.example.VaccifyMe.dto.ResponseDTO.StatusResponseDto;
import com.example.VaccifyMe.service.UserService;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody UserRequestDto userRequestDto){
        UserResponseDto userResponseDto = userService.addUser(userRequestDto);
        return new ResponseEntity(userResponseDto, HttpStatus.CREATED);
    }

    // find by emailId
    @GetMapping("/getByEmail")
    public ResponseEntity findByEmailId(@RequestParam String emailId){
        UserResponseDto userResponseDto = userService.findByEmail(emailId);
        return new ResponseEntity(userResponseDto, HttpStatus.FOUND);
    }

    // update the name of the user mobno.
    @PutMapping("/update-name")
    public ResponseEntity updateName(@RequestParam String mobNo, @RequestParam String name){
        int user = userService.updateName(mobNo, name);
        return new ResponseEntity(user +" name updated", HttpStatus.OK);

    }

    // all the users who have not taken a single dose.
    @GetMapping("/haveNotTakenSingleVaccine")
    public ResponseEntity notTakenSingleVaccine(){
        List<StatusResponseDto> responseDto = userService.notTakenSingleVaccine();
        return new ResponseEntity(responseDto, HttpStatus.FOUND);
    }


    //all the users who have taken dose1 but not dose2
    @GetMapping("/taken-dose1-not-dose2")
    public ResponseEntity notTakenDose2(){
        List<StatusResponseDto> responseDto = userService.notTakenDose2();
        return new ResponseEntity(responseDto, HttpStatus.FOUND);
    }

    // all the users who are fully vaccinated
    @GetMapping("/fully-vaccinated")
    public ResponseEntity fullyVaccinated(){
        List<StatusResponseDto> responseDto = userService.fullyVaccinated();
        return new ResponseEntity(responseDto, HttpStatus.FOUND);
    }

    //all male users who have not taken even a single dose
    @GetMapping("/fully-unvaccinated-male")
    public ResponseEntity fullyUnvaccinatedMales(){
        List<StatusResponseDto> responseDto = userService.fullyUnvaccinatedMales();
        return new ResponseEntity(responseDto, HttpStatus.FOUND);
    }

    // all female users who are fully vaccinated.
    @GetMapping("/fully-vaccinated-females")
    public ResponseEntity fullyVaccinatedFemales(){
        List<StatusResponseDto> responseDto = userService.fullyVaccinatedFemales();
        return new ResponseEntity(responseDto, HttpStatus.FOUND);
    }
}

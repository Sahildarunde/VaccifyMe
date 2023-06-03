package com.example.VaccifyMe.controller;

import com.example.VaccifyMe.dto.RequestDTO.DoctorRequestDto;
import com.example.VaccifyMe.dto.ResponseDTO.DoctorResponseDto;
import com.example.VaccifyMe.exception.CenterNotPresentException;
import com.example.VaccifyMe.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired DoctorService doctorService;
    @PostMapping("/add")
    public ResponseEntity addDoctor(@RequestBody DoctorRequestDto doctorRequestDto) throws CenterNotPresentException {

        try {
            DoctorResponseDto doctorResponseDto = doctorService.addDoctor(doctorRequestDto);
            return new ResponseEntity(doctorResponseDto, HttpStatus.CREATED);
        }
        catch (CenterNotPresentException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    // get all the doctors who have more than 10 appointments
    // get all the doctors who's age is above 40
    //get the ration of male to female doctors
    //update the details of the doctor

}

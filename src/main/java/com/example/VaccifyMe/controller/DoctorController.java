package com.example.VaccifyMe.controller;

import com.example.VaccifyMe.dto.RequestDTO.DoctorRequestDto;
import com.example.VaccifyMe.dto.ResponseDTO.DoctorResponseDto;
import com.example.VaccifyMe.exception.CenterNotPresentException;
import com.example.VaccifyMe.exception.DoctorNotFoundException;
import com.example.VaccifyMe.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;

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
    @GetMapping("/get/doctors/appointments>10")
    public ResponseEntity getAllDoctorsMorethan10Appointments(){
        List<DoctorResponseDto> doctorResponseDtos = doctorService.getAllDoctorsMorethan10Appointments();
        return new ResponseEntity(doctorResponseDtos, HttpStatus.CREATED);
    }
    // get all the doctors who's age is above 40

    //get the ratio of male to female doctors
    @GetMapping("/get/male-female-doctor/ratio")
    public ResponseEntity getMaleFemaleDoctorRatio(){
        Double MaleFemaleRatio = doctorService.getMaleFemaleDoctorRatio();
        return new ResponseEntity(MaleFemaleRatio, HttpStatus.CREATED);
    }

    //update the details of the doctor
    @PutMapping("/update")
    public ResponseEntity updateDoctor(@PathVariable("id") int id, @RequestBody DoctorRequestDto doctorRequestDto) throws DoctorNotFoundException {
        try {
            DoctorResponseDto doctorResponseDto = doctorService.updateDoctor(id, doctorRequestDto);
            return new ResponseEntity(doctorResponseDto, HttpStatus.OK);
        } catch (DoctorNotFoundException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}

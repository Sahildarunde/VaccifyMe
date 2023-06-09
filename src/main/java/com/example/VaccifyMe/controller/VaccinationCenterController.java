package com.example.VaccifyMe.controller;

import com.example.VaccifyMe.Enum.CenterType;
import com.example.VaccifyMe.dto.RequestDTO.CenterRequestDto;
import com.example.VaccifyMe.dto.ResponseDTO.CenterResponseDto;
import com.example.VaccifyMe.dto.ResponseDTO.DoctorResponseDto;
import com.example.VaccifyMe.service.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/center")
public class VaccinationCenterController {
    @Autowired VaccinationCenterService vaccinationCenterService;

    @PostMapping("/add")
    public ResponseEntity addVaccinationCenter(@RequestBody CenterRequestDto centerRequestDto){
        return new ResponseEntity(vaccinationCenterService.addCenter(centerRequestDto), HttpStatus.CREATED);
    }

    // give the list of all doctors at a particular center
    @GetMapping("/get-all-doctors/{centerId}")
    public ResponseEntity getAllDoctorsAtCenter(@PathVariable("centerId") int centerId){
        List<DoctorResponseDto> doctorResponseDtos = vaccinationCenterService.getAllDoctorsAtCenter(centerId);
        return new ResponseEntity(doctorResponseDtos, HttpStatus.CREATED);
    }


    // give the list of all male doctors at a particular center
    @GetMapping("/get-all-male-doctors/{centerId}")
    public ResponseEntity getAllMaleDoctorsAtCenter(@PathVariable("centerId") int centerId){
        List<DoctorResponseDto> doctorResponseDtos = vaccinationCenterService.getAllMaleDoctorsAtCenter(centerId);
        return new ResponseEntity(doctorResponseDtos, HttpStatus.CREATED);
    }
    // give the list of all females doctors at a particular center
    @GetMapping("/get-all-female-doctors/{centerId}")
    public ResponseEntity getAllFemaleDoctorsAtCenter(@PathVariable("centerId") int centerId){
        List<DoctorResponseDto> doctorResponseDtos = vaccinationCenterService.getAllFemaleDoctorsAtCenter(centerId);
        return new ResponseEntity(doctorResponseDtos, HttpStatus.CREATED);
    }
    //give the list of all male above age 40 doctors at a particular center
    @GetMapping("/get-all-male-doctors-above-40/{centerId}")
    public ResponseEntity getAllMaleDoctorsByAgeAbove40(@PathVariable("centerId") int centerId){
        List<DoctorResponseDto> doctorResponseDtos = vaccinationCenterService.getAllMaleDoctorsByAgeAbove40(centerId);
        return new ResponseEntity(doctorResponseDtos, HttpStatus.CREATED);
    }
    //give all center of a particular center type
    @GetMapping("/get-all-center-by-type/{centerType}")
    public ResponseEntity getAllCenterByType(@PathVariable("centerType")CenterType centerType){
        List<CenterResponseDto> centerResponseDtos = vaccinationCenterService.getAllCenterByType(centerType);
        return new ResponseEntity(centerResponseDtos, HttpStatus.CREATED);
    }
}

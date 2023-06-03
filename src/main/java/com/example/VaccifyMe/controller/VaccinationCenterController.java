package com.example.VaccifyMe.controller;

import com.example.VaccifyMe.dto.RequestDTO.CenterRequestDto;
import com.example.VaccifyMe.service.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/center")
public class VaccinationCenterController {
    @Autowired VaccinationCenterService vaccinationCenterService;

    @PostMapping("/add")
    public ResponseEntity addVaccinationCenter(@RequestBody CenterRequestDto centerRequestDto){
        return new ResponseEntity(vaccinationCenterService.addCenter(centerRequestDto), HttpStatus.CREATED);
    }

    // give the list of all doctors at a particular center
    // give the list of all male doctors at a particular center
    // give the list of all females doctors at a particular center
    //give the list of all male above age 40 doctors at a particular center
    //give all center of a particular center type
}

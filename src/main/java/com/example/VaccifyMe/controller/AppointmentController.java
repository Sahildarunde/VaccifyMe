package com.example.VaccifyMe.controller;

import com.example.VaccifyMe.dto.RequestDTO.AppointmentRequestDto;
import com.example.VaccifyMe.dto.ResponseDTO.AppointmentResponseDto;
import com.example.VaccifyMe.dto.ResponseDTO.CertificateResponseDto;
import com.example.VaccifyMe.exception.DoctorNotFoundException;
import com.example.VaccifyMe.exception.NotEligibleForDose1Certificate;
import com.example.VaccifyMe.exception.NotEligibleForDoseException;
import com.example.VaccifyMe.exception.UserNotFoundException;
import com.example.VaccifyMe.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired AppointmentService appointmentService;
    @PostMapping("/book")
    public ResponseEntity bookAppointment(@RequestBody AppointmentRequestDto appointmentRequestDto) throws UserNotFoundException, DoctorNotFoundException, NotEligibleForDoseException {
        try {
            AppointmentResponseDto appointmentResponseDto = appointmentService.bookAppointment(appointmentRequestDto);
            return new ResponseEntity<>(appointmentResponseDto, HttpStatus.CREATED);
        }catch (UserNotFoundException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }catch (DoctorNotFoundException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (NotEligibleForDoseException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //generate certificates
        // --> one dose(post)
        // --> both dose(put)

    @GetMapping("get/certificate/dose1/{id}")
    public ResponseEntity getCertificateDose1(@PathVariable("id") int id) throws UserNotFoundException, NotEligibleForDose1Certificate {
        try {
            CertificateResponseDto certificateResponseDto = appointmentService.getCertificateDose1(id);
            return new ResponseEntity<>(certificateResponseDto, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("get/certificate/dose2/{id}")
    public ResponseEntity getCertificateDose2(@PathVariable("id") int id) throws UserNotFoundException, NotEligibleForDose1Certificate {
        try {
            CertificateResponseDto certificateResponseDto = appointmentService.getCertificateDose2(id);
            return new ResponseEntity<>(certificateResponseDto, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

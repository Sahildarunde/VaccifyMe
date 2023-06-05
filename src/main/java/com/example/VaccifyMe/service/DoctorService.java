package com.example.VaccifyMe.service;

import com.example.VaccifyMe.dto.RequestDTO.DoctorRequestDto;
import com.example.VaccifyMe.dto.ResponseDTO.DoctorResponseDto;
import com.example.VaccifyMe.exception.CenterNotPresentException;
import com.example.VaccifyMe.exception.DoctorNotFoundException;

import java.util.List;

public interface DoctorService {

    public DoctorResponseDto addDoctor(DoctorRequestDto doctorRequestDto) throws CenterNotPresentException;

    List<DoctorResponseDto> getAllDoctorsMorethan10Appointments();

    Double getMaleFemaleDoctorRatio();

    DoctorResponseDto updateDoctor(int id, DoctorRequestDto doctorRequestDto) throws DoctorNotFoundException;
}

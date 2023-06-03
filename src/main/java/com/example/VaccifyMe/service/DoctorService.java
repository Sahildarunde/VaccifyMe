package com.example.VaccifyMe.service;

import com.example.VaccifyMe.dto.RequestDTO.DoctorRequestDto;
import com.example.VaccifyMe.dto.ResponseDTO.DoctorResponseDto;
import com.example.VaccifyMe.exception.CenterNotPresentException;

public interface DoctorService {

    public DoctorResponseDto addDoctor(DoctorRequestDto doctorRequestDto) throws CenterNotPresentException;
}

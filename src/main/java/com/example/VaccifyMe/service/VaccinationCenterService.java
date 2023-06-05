package com.example.VaccifyMe.service;

import com.example.VaccifyMe.Enum.CenterType;
import com.example.VaccifyMe.dto.RequestDTO.CenterRequestDto;
import com.example.VaccifyMe.dto.ResponseDTO.CenterResponseDto;
import com.example.VaccifyMe.dto.ResponseDTO.DoctorResponseDto;

import java.util.List;


public interface VaccinationCenterService {
    CenterResponseDto addCenter(CenterRequestDto centerRequestDto);

    List<DoctorResponseDto> getAllDoctorsAtCenter(int centerId);

    List<DoctorResponseDto> getAllMaleDoctorsAtCenter(int centerId);

    List<DoctorResponseDto> getAllFemaleDoctorsAtCenter(int centerId);

    List<DoctorResponseDto> getAllMaleDoctorsByAgeAbove40(int centerId);

    List<CenterResponseDto> getAllCenterByType(CenterType centerType);
}

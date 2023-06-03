package com.example.VaccifyMe.service;

import com.example.VaccifyMe.dto.RequestDTO.CenterRequestDto;
import com.example.VaccifyMe.dto.ResponseDTO.CenterResponseDto;


public interface VaccinationCenterService {
    CenterResponseDto addCenter(CenterRequestDto centerRequestDto);
}

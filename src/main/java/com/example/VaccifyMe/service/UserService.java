package com.example.VaccifyMe.service;

import com.example.VaccifyMe.dto.RequestDTO.UserRequestDto;
import com.example.VaccifyMe.dto.ResponseDTO.UserResponseDto;
import com.example.VaccifyMe.dto.ResponseDTO.StatusResponseDto;

import java.util.List;

public interface UserService {
    public UserResponseDto addUser(UserRequestDto userRequestDto);


    UserResponseDto findByEmail(String emailId);

    int updateName(String mobNo, String name);

    List<StatusResponseDto> notTakenSingleVaccine();

    List<StatusResponseDto> notTakenDose2();

    List<StatusResponseDto> fullyVaccinated();

    List<StatusResponseDto> fullyUnvaccinatedMales();

    List<StatusResponseDto> fullyVaccinatedFemales();
}

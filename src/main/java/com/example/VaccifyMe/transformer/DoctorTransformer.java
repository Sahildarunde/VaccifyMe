package com.example.VaccifyMe.transformer;

import com.example.VaccifyMe.dto.RequestDTO.DoctorRequestDto;
import com.example.VaccifyMe.dto.ResponseDTO.CenterResponseDto;
import com.example.VaccifyMe.dto.ResponseDTO.DoctorResponseDto;
import com.example.VaccifyMe.model.Doctor;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DoctorTransformer {
    public Doctor DoctorRequestDtoToDoctor(DoctorRequestDto doctorRequestDto){
        return Doctor.builder()
                .name(doctorRequestDto.getName())
                .age(doctorRequestDto.getAge())
                .emailId(doctorRequestDto.getEmailId())
                .mobNo(doctorRequestDto.getMobNo())
                .gender(doctorRequestDto.getGender())
                .build();
    }
    public DoctorResponseDto DoctorToDoctorResponseDto(Doctor doctor){
        CenterResponseDto centerResponseDto = VaccinationCenterTransformer.CenterToCenterResponseDto(doctor.getVaccinationCenter());
        return DoctorResponseDto.builder()
                .name(doctor.getName())
                .emailId(doctor.getEmailId())
                .mobNo(doctor.getMobNo())
                .centerResponseDto(centerResponseDto)
                .build();
    }
}

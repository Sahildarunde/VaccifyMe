package com.example.VaccifyMe.service.impl;

import com.example.VaccifyMe.Enum.CenterType;
import com.example.VaccifyMe.Enum.Gender;
import com.example.VaccifyMe.dao.CenterRepository;
import com.example.VaccifyMe.dao.DoctorRepository;
import com.example.VaccifyMe.dto.RequestDTO.CenterRequestDto;
import com.example.VaccifyMe.dto.ResponseDTO.CenterResponseDto;
import com.example.VaccifyMe.dto.ResponseDTO.DoctorResponseDto;
import com.example.VaccifyMe.model.Doctor;
import com.example.VaccifyMe.model.VaccinationCenter;
import com.example.VaccifyMe.service.VaccinationCenterService;
import com.example.VaccifyMe.transformer.DoctorTransformer;
import com.example.VaccifyMe.transformer.VaccinationCenterTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CenterServiceImpl implements VaccinationCenterService {
    @Autowired CenterRepository centerRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Override
    public CenterResponseDto addCenter(CenterRequestDto centerRequestDto) {
        // dto --> entity
        VaccinationCenter vaccinationCenter = VaccinationCenterTransformer.CenterRequestDtoToCenter(centerRequestDto);
        //save into db
        VaccinationCenter savedCenter = centerRepository.save(vaccinationCenter);
        // saved center --> responseDto
        return VaccinationCenterTransformer.CenterToCenterResponseDto(savedCenter);

    }

    @Override
    public List<DoctorResponseDto> getAllDoctorsAtCenter(int centerId) {
        List<Doctor>  doctors = doctorRepository.findByVaccinationCenterId(centerId);
        List<DoctorResponseDto> doctorResponseDtos = new ArrayList<>();
        for(Doctor doctor : doctors){
            doctorResponseDtos.add(DoctorTransformer.DoctorToDoctorResponseDto(doctor));
        }
        return doctorResponseDtos;
    }

    @Override
    public List<DoctorResponseDto> getAllMaleDoctorsAtCenter(int centerId) {
        List<Doctor>  doctors = doctorRepository.findByVaccinationCenterIdAndGender(centerId, Gender.MALE);
        List<DoctorResponseDto> doctorResponseDtos = new ArrayList<>();
        for(Doctor doctor : doctors){
            doctorResponseDtos.add(DoctorTransformer.DoctorToDoctorResponseDto(doctor));
        }
        return doctorResponseDtos;
    }

    @Override
    public List<DoctorResponseDto> getAllFemaleDoctorsAtCenter(int centerId) {
        List<Doctor>  doctors = doctorRepository.findByVaccinationCenterIdAndGender(centerId, Gender.FEMALE);
        List<DoctorResponseDto> doctorResponseDtos = new ArrayList<>();
        for(Doctor doctor : doctors){
            doctorResponseDtos.add(DoctorTransformer.DoctorToDoctorResponseDto(doctor));
        }
        return doctorResponseDtos;
    }

    @Override
    public List<DoctorResponseDto> getAllMaleDoctorsByAgeAbove40(int centerId) {
        List<Doctor>  doctors = doctorRepository.findByVaccinationCenterIdAndGender(centerId, Gender.MALE);
        List<DoctorResponseDto> doctorResponseDtos = new ArrayList<>();
        for(Doctor doctor : doctors){
            if(doctor.getAge() > 40) {
                doctorResponseDtos.add(DoctorTransformer.DoctorToDoctorResponseDto(doctor));
            }
        }
        return doctorResponseDtos;
    }

    @Override
    public List<CenterResponseDto> getAllCenterByType(CenterType centerType) {
        List<VaccinationCenter> centers = centerRepository.findByCenterType(centerType);
        List<CenterResponseDto> centerResponseDtos = new ArrayList<>();
        for(VaccinationCenter center : centers){
            centerResponseDtos.add(VaccinationCenterTransformer.CenterToCenterResponseDto(center));
        }
        return centerResponseDtos;
    }
}

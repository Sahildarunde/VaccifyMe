package com.example.VaccifyMe.service.impl;

import com.example.VaccifyMe.dao.CenterRepository;
import com.example.VaccifyMe.dao.DoctorRepository;
import com.example.VaccifyMe.dto.RequestDTO.DoctorRequestDto;
import com.example.VaccifyMe.dto.ResponseDTO.CenterResponseDto;
import com.example.VaccifyMe.dto.ResponseDTO.DoctorResponseDto;
import com.example.VaccifyMe.exception.CenterNotPresentException;
import com.example.VaccifyMe.model.Doctor;
import com.example.VaccifyMe.model.VaccinationCenter;
import com.example.VaccifyMe.service.DoctorService;
import com.example.VaccifyMe.transformer.DoctorTransformer;
import com.example.VaccifyMe.transformer.VaccinationCenterTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired DoctorRepository doctorRepository;
    @Autowired CenterRepository centerRepository;
    @Override
    public DoctorResponseDto addDoctor(DoctorRequestDto doctorRequestDto) throws CenterNotPresentException {
        Optional<VaccinationCenter> optionalCenter = centerRepository.findById(doctorRequestDto.getCenterId());

        if(!optionalCenter.isPresent()){
            throw new CenterNotPresentException("Invalid center id");
        }
        VaccinationCenter center = optionalCenter.get();

        // dto --> entity
        Doctor doctor = DoctorTransformer.DoctorRequestDtoToDoctor(doctorRequestDto);
        doctor.setVaccinationCenter(center);
        //add doctor to current list of doctors list
        center.getDoctors().add(doctor);
        // save to db
        VaccinationCenter savedCenter = centerRepository.save(center); // saves both center & doctor

        return DoctorTransformer.DoctorToDoctorResponseDto(doctor);

    }
}

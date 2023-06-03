package com.example.VaccifyMe.service.impl;

import com.example.VaccifyMe.dao.CenterRepository;
import com.example.VaccifyMe.dto.RequestDTO.CenterRequestDto;
import com.example.VaccifyMe.dto.ResponseDTO.CenterResponseDto;
import com.example.VaccifyMe.model.VaccinationCenter;
import com.example.VaccifyMe.service.VaccinationCenterService;
import com.example.VaccifyMe.transformer.VaccinationCenterTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CenterServiceImpl implements VaccinationCenterService {
    @Autowired CenterRepository centerRepository;
    @Override
    public CenterResponseDto addCenter(CenterRequestDto centerRequestDto) {
        // dto --> entity
        VaccinationCenter vaccinationCenter = VaccinationCenterTransformer.CenterRequestDtoToCenter(centerRequestDto);
        //save into db
        VaccinationCenter savedCenter = centerRepository.save(vaccinationCenter);
        // saved center --> responseDto
        return VaccinationCenterTransformer.CenterToCenterResponseDto(savedCenter);

    }
}

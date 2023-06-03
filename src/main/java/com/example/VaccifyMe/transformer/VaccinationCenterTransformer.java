package com.example.VaccifyMe.transformer;

import com.example.VaccifyMe.dto.RequestDTO.CenterRequestDto;
import com.example.VaccifyMe.dto.ResponseDTO.CenterResponseDto;
import com.example.VaccifyMe.model.VaccinationCenter;
import lombok.experimental.UtilityClass;

@UtilityClass
public class VaccinationCenterTransformer {
    public VaccinationCenter CenterRequestDtoToCenter(CenterRequestDto centerRequestDto){
        return VaccinationCenter.builder()
                .name(centerRequestDto.getName())
                .location(centerRequestDto.getLocation())
                .centerType(centerRequestDto.getCenterType())
                .build();
    }

    public CenterResponseDto CenterToCenterResponseDto(VaccinationCenter center) {
        return CenterResponseDto.builder()
                .name(center.getName())
                .location(center.getLocation())
                .centerType(center.getCenterType())
                .build();
    }
}

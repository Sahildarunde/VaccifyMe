package com.example.VaccifyMe.service.impl;

import com.example.VaccifyMe.Enum.VaccineType;
import com.example.VaccifyMe.dto.RequestDTO.AppointmentRequestDto;
import com.example.VaccifyMe.model.Dose1;
import com.example.VaccifyMe.model.User;
import com.example.VaccifyMe.service.Dose1Service;
import com.example.VaccifyMe.transformer.Dose1Transformer;
import org.springframework.stereotype.Service;

@Service
public class Dose1ServiceImpl implements Dose1Service {


    @Override
    public Dose1 createDose1(User user, VaccineType vaccineType) {
       return Dose1Transformer.BookDose1Appointment(user, vaccineType);
    }
}

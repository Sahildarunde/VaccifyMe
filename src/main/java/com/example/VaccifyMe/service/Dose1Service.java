package com.example.VaccifyMe.service;

import com.example.VaccifyMe.Enum.VaccineType;
import com.example.VaccifyMe.dto.RequestDTO.AppointmentRequestDto;
import com.example.VaccifyMe.model.Dose1;
import com.example.VaccifyMe.model.User;

public interface Dose1Service {
    public Dose1 createDose1(User user, VaccineType vaccineType);
}

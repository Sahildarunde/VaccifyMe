package com.example.VaccifyMe.transformer;

import com.example.VaccifyMe.Enum.VaccineType;
import com.example.VaccifyMe.model.Dose1;
import com.example.VaccifyMe.model.User;
import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class Dose1Transformer {
    public Dose1 BookDose1Appointment(User user, VaccineType vaccineType){
        return Dose1.builder()
                .doseId(String.valueOf(UUID.randomUUID()))
                .vaccineType(vaccineType)
                .user(user)
                .build();
    }
}

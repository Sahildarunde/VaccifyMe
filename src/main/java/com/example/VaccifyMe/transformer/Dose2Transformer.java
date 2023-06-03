package com.example.VaccifyMe.transformer;

import com.example.VaccifyMe.Enum.VaccineType;
import com.example.VaccifyMe.model.Dose1;
import com.example.VaccifyMe.model.Dose2;
import com.example.VaccifyMe.model.User;
import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class Dose2Transformer {
    public Dose2 BookDose2Appointment(User user, VaccineType vaccineType){
        return Dose2.builder()
                .doseId(String.valueOf(UUID.randomUUID()))
                .vaccineType(vaccineType)
                .user(user)
                .build();
    }
}

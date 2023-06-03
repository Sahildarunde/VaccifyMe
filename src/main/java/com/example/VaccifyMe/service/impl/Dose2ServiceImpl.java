package com.example.VaccifyMe.service.impl;

import com.example.VaccifyMe.Enum.VaccineType;
import com.example.VaccifyMe.model.Dose2;
import com.example.VaccifyMe.model.User;
import com.example.VaccifyMe.service.Dose2Service;
import com.example.VaccifyMe.transformer.Dose2Transformer;
import org.springframework.stereotype.Service;

@Service
public class Dose2ServiceImpl implements Dose2Service {
    @Override
    public Dose2 createDose2(User user, VaccineType vaccineType) {
        return Dose2Transformer.BookDose2Appointment(user,vaccineType);
    }
}

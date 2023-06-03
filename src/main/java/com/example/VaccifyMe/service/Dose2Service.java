package com.example.VaccifyMe.service;

import com.example.VaccifyMe.Enum.VaccineType;
import com.example.VaccifyMe.model.Dose2;
import com.example.VaccifyMe.model.User;


public interface Dose2Service {
    public Dose2 createDose2(User user, VaccineType vaccineType);
}

package com.example.VaccifyMe.dto.RequestDTO;

import com.example.VaccifyMe.Enum.DoseNo;
import com.example.VaccifyMe.Enum.VaccineType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppointmentRequestDto {

    DoseNo doseNo;
    int userId;
    int doctorId;
    VaccineType vaccineType;
}

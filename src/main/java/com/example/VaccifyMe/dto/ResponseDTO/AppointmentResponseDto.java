package com.example.VaccifyMe.dto.ResponseDTO;

import com.example.VaccifyMe.Enum.DoseNo;
import com.example.VaccifyMe.Enum.VaccineType;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apache.logging.log4j.message.StringFormattedMessage;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder

public class AppointmentResponseDto {
    String userName;

    String appointmentNo;

    Date dateOfAppointment;

    DoseNo doseNo;

    CenterResponseDto centerResponseDto;

    String doctorName;

    VaccineType vaccineType;
}

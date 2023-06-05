package com.example.VaccifyMe.dto.ResponseDTO;

import com.example.VaccifyMe.Enum.DoseNo;
import com.example.VaccifyMe.model.Dose1;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder

public class CertificateResponseDto {
    String message;

    int id;

    DoseNo doseNo;
}

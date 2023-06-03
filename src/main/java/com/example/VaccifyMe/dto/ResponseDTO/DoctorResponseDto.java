package com.example.VaccifyMe.dto.ResponseDTO;

import com.example.VaccifyMe.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder

public class DoctorResponseDto {

    String name;

    String emailId;

    String mobNo;

    CenterResponseDto centerResponseDto;
}

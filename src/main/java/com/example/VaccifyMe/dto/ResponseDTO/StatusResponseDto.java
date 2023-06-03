package com.example.VaccifyMe.dto.ResponseDTO;

import com.example.VaccifyMe.Enum.Gender;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StatusResponseDto {
    String name;

    int age;

    String emailId;

    String mobNo;

    Gender gender;
}

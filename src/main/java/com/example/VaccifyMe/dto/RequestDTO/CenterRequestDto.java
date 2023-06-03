package com.example.VaccifyMe.dto.RequestDTO;

import com.example.VaccifyMe.Enum.CenterType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CenterRequestDto {
    String name;

    String location;

    CenterType centerType;
}

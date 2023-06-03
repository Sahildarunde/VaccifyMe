package com.example.VaccifyMe.transformer;

import com.example.VaccifyMe.dto.RequestDTO.UserRequestDto;
import com.example.VaccifyMe.dto.ResponseDTO.UserResponseDto;
import com.example.VaccifyMe.model.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserTransformer {
    public User UserRequestDtoToUser(UserRequestDto userRequestDto){
        return User.builder()
                .name(userRequestDto.getName())
                .age(userRequestDto.getAge())
                .emailId(userRequestDto.getEmailId())
                .gender(userRequestDto.getGender())
                .mobNo(userRequestDto.getMobNo())
                .build();
    }
    public UserResponseDto UserToUserResponseDto(User user){
        return UserResponseDto.builder()
                .name(user.getName())
                .message("Congrats!! you've successfully registered at VaccifyMe")
                .build();
    }
}

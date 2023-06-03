package com.example.VaccifyMe.transformer;

import com.example.VaccifyMe.Enum.VaccineType;
import com.example.VaccifyMe.dto.RequestDTO.AppointmentRequestDto;
import com.example.VaccifyMe.dto.ResponseDTO.AppointmentResponseDto;
import com.example.VaccifyMe.dto.ResponseDTO.CenterResponseDto;
import com.example.VaccifyMe.model.Appointment;
import com.example.VaccifyMe.model.Doctor;
import com.example.VaccifyMe.model.User;
import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class AppointmentTransformer {
    public Appointment createAppointment(Doctor doctor, User user, AppointmentRequestDto appointmentRequestDto){
        return Appointment.builder()
                .appointmentNo(String.valueOf(UUID.randomUUID()))
                .doseNo(appointmentRequestDto.getDoseNo())
                .user(user)
                .doctor(doctor)
                .build();
    }
    public AppointmentResponseDto appointmentToResponseDto(VaccineType vaccineType, Appointment appointment, CenterResponseDto centerResponseDto, Appointment savedAppointment){
        return AppointmentResponseDto.builder()
                .userName(appointment.getUser().getName())
                .appointmentNo(appointment.getAppointmentNo())
                .dateOfAppointment(savedAppointment.getDateOfAppointment())
                .doseNo(appointment.getDoseNo())
                .doctorName(appointment.getDoctor().getName())
                .vaccineType(vaccineType)
                .centerResponseDto(centerResponseDto)
                .build();
    }
}

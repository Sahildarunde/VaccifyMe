package com.example.VaccifyMe.service;

import com.example.VaccifyMe.dto.RequestDTO.AppointmentRequestDto;
import com.example.VaccifyMe.dto.ResponseDTO.AppointmentResponseDto;
import com.example.VaccifyMe.exception.DoctorNotFoundException;
import com.example.VaccifyMe.exception.NotEligibleForDoseException;
import com.example.VaccifyMe.exception.UserNotFoundException;

public interface AppointmentService {

    public AppointmentResponseDto bookAppointment(AppointmentRequestDto appointmentRequestDto) throws UserNotFoundException, DoctorNotFoundException, NotEligibleForDoseException;
}

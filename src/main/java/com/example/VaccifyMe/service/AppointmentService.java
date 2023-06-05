package com.example.VaccifyMe.service;

import com.example.VaccifyMe.dto.RequestDTO.AppointmentRequestDto;
import com.example.VaccifyMe.dto.ResponseDTO.AppointmentResponseDto;
import com.example.VaccifyMe.dto.ResponseDTO.CertificateResponseDto;
import com.example.VaccifyMe.exception.*;

public interface AppointmentService {

    public AppointmentResponseDto bookAppointment(AppointmentRequestDto appointmentRequestDto) throws UserNotFoundException, DoctorNotFoundException, NotEligibleForDoseException;

    CertificateResponseDto getCertificateDose1(int id) throws UserNotFoundException, NotEligibleForDose1Certificate;

    CertificateResponseDto getCertificateDose2(int id) throws UserNotFoundException, NotEligibleForDose1Certificate, NotEligibleForDose2Certificate;
}

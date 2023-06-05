package com.example.VaccifyMe.service.impl;

import com.example.VaccifyMe.Enum.DoseNo;
import com.example.VaccifyMe.dao.Dose1Repository;
import com.example.VaccifyMe.dao.DoctorRepository;
import com.example.VaccifyMe.dao.UserRepository;
import com.example.VaccifyMe.dto.RequestDTO.AppointmentRequestDto;
import com.example.VaccifyMe.dto.ResponseDTO.AppointmentResponseDto;
import com.example.VaccifyMe.dto.ResponseDTO.CenterResponseDto;
import com.example.VaccifyMe.dto.ResponseDTO.CertificateResponseDto;
import com.example.VaccifyMe.exception.*;
import com.example.VaccifyMe.model.*;
import com.example.VaccifyMe.service.AppointmentService;
import com.example.VaccifyMe.service.Dose1Service;
import com.example.VaccifyMe.service.Dose2Service;
import com.example.VaccifyMe.transformer.AppointmentTransformer;
import com.example.VaccifyMe.transformer.VaccinationCenterTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired UserRepository userRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired Dose1Service dose1Service;
    @Autowired Dose2Service dose2Service;
    @Autowired
    Dose1Repository appointmentRepository;

    @Autowired JavaMailSender emailSender;

    @Override
    public AppointmentResponseDto bookAppointment(AppointmentRequestDto appointmentRequestDto) throws UserNotFoundException, DoctorNotFoundException, NotEligibleForDoseException {
        //check whether exist or not
        Optional<User> OptionalUser = userRepository.findById(appointmentRequestDto.getUserId());
        if(!OptionalUser.isPresent()){
            throw new UserNotFoundException("User not found!");
        }
        //check whether doctor exist or not
        Optional<Doctor> OptionalDoctor = doctorRepository.findById(appointmentRequestDto.getDoctorId());
        if(!OptionalDoctor.isPresent()){
            throw new DoctorNotFoundException("Doctor Not Found!");
        }

        User user = OptionalUser.get();
        Doctor doctor = OptionalDoctor.get();

        if(appointmentRequestDto.getDoseNo() == DoseNo.DOSE_1){
            Dose1 dose1 = dose1Service.createDose1(user, appointmentRequestDto.getVaccineType());
            user.setDose1Taken(true);
            user.setDose1(dose1);
        }else{
            if(!user.isDose1Taken()){
                throw new NotEligibleForDoseException("Sorry! you're not yet eligible for Dose 2");
            }
            Dose2 dose2 = dose2Service.createDose2(user, appointmentRequestDto.getVaccineType());
            user.setDose2Taken(true);
            user.setDose2(dose2);
        }

        Appointment appointment = AppointmentTransformer.createAppointment(doctor, user, appointmentRequestDto);

        user.getAppointments().add(appointment);
        User savedUser = userRepository.save(user); // save dose/dose2 & appointment
        Appointment savedAppointment = savedUser.getAppointments().get(savedUser.getAppointments().size()-1);
        doctor.getAppointments().add(savedAppointment);
        doctorRepository.save(doctor);


        //Send Emails
        String text = "Congrats!!" + user.getName() + " Your dose "+ appointmentRequestDto.getDoseNo() + " of vaccine type - "
                +appointmentRequestDto.getVaccineType() +" for doctor - "+ doctor.getName() + " has been booked!!";
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("projectdemomail32@gmail.com");
        message.setTo(user.getEmailId());
        message.setSubject("Appointment Booked !!!");
        message.setText(text);
        emailSender.send(message);


        //prepare response dto

        CenterResponseDto centerResponseDto = VaccinationCenterTransformer.CenterToCenterResponseDto(doctor.getVaccinationCenter());

        return AppointmentTransformer.appointmentToResponseDto
                (appointmentRequestDto.getVaccineType(),appointment, centerResponseDto, savedAppointment);

    }

    @Override
    public CertificateResponseDto getCertificateDose1(int id) throws UserNotFoundException, NotEligibleForDose1Certificate {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("Sorry! User is not registered");
        }
        if(optionalUser.get().isDose1Taken() == false){
            throw new NotEligibleForDose1Certificate("Sorry! You're not eligible for Dose 1 certificate");
        }
        String message = "Congratulations! " +optionalUser.get().getName()+" You have successfully taken Dose1";
        CertificateResponseDto certificateResponseDto = new CertificateResponseDto();
        certificateResponseDto.setMessage(message);
        certificateResponseDto.setId(optionalUser.get().getId());
        certificateResponseDto.setDoseNo(DoseNo.DOSE_1);

        return certificateResponseDto;
    }

    @Override
    public CertificateResponseDto getCertificateDose2(int id) throws UserNotFoundException, NotEligibleForDose1Certificate, NotEligibleForDose2Certificate {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("Sorry! User is not registered");
        }

        if(optionalUser.get().isDose1Taken() == false){
            throw new NotEligibleForDose1Certificate("Sorry! You've not taken dose 1");
        }
        if(optionalUser.get().isDose2Taken() == false){
            throw new NotEligibleForDose2Certificate("Sorry! You're not eligible for certificate");
        }
        String message = "Congratulations! " +optionalUser.get().getName()+" You fully vaccinated";
        CertificateResponseDto certificateResponseDto = new CertificateResponseDto();
        certificateResponseDto.setMessage(message);
        certificateResponseDto.setId(optionalUser.get().getId());
        certificateResponseDto.setDoseNo(DoseNo.DOSE_2);

        return certificateResponseDto;
    }
}

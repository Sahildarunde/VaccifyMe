package com.example.VaccifyMe.dao;

import com.example.VaccifyMe.Enum.Gender;
import com.example.VaccifyMe.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {


    List<Doctor> findByVaccinationCenterId(int centerId);

    List<Doctor> findByVaccinationCenterIdAndGender(int centerId, Gender gender);


    @Query(value = "SELECT d.* FROM Doctor d JOIN Appointment a ON d.id = a.doctor_id GROUP BY d.id HAVING COUNT(a.id) > 10", nativeQuery = true)
    List<Doctor> findDoctorsWithMoreThanTenAppointments();

    int countByGender(Gender gender);
}

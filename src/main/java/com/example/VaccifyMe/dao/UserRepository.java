package com.example.VaccifyMe.dao;

import com.example.VaccifyMe.dto.ResponseDTO.UserResponseDto;
import com.example.VaccifyMe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


    @Query(value = "SELECT * FROM user WHERE email_id = :email", nativeQuery = true)
    User findByEmailId(String email);

    @Modifying
    @Query(value = "UPDATE user SET name = ':name' WHERE mob_no = :mobNo", nativeQuery = true)
    int updateName(String mobNo, String name);

    @Query(value = "SELECT * FROM user WHERE is_dose1_taken = false", nativeQuery = true)
    List<User> notTakenSingleVaccine();

    @Query(value = "SELECT * FROM user WHERE is_dose1_taken = true AND is_dose2_taken = false", nativeQuery = true)
    List<User> notTakenDose2();

    @Query(value = "SELECT * FROM user WHERE is_dose1_taken = true AND is_dose2_taken = true", nativeQuery = true)
    List<User> fullyVaccinated();

    @Query(value = "SELECT * FROM  user WHERE gender = 'MALE' AND is_dose1_taken = false AND is_dose2_taken = false;", nativeQuery = true)
    List<User> fullyUnvaccinatedMales();

    @Query(value = "SELECT * FROM  user WHERE gender = 'FEMALE' AND is_dose1_taken = true AND is_dose2_taken = true;", nativeQuery = true)
    List<User> fullyVaccinatedFemales();
}

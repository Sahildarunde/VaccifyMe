package com.example.VaccifyMe.dao;

import com.example.VaccifyMe.Enum.CenterType;
import com.example.VaccifyMe.model.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CenterRepository extends JpaRepository<VaccinationCenter, Integer> {

    List<VaccinationCenter> findByCenterType(CenterType centerType);
}

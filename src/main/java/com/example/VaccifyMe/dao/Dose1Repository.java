package com.example.VaccifyMe.dao;

import com.example.VaccifyMe.model.Appointment;
import com.example.VaccifyMe.model.Dose1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Dose1Repository extends JpaRepository<Dose1,Integer> {
}

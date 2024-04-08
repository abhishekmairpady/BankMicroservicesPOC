package com.example.enroll_service.dao;

import com.example.enroll_service.model.Enroll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollDao extends JpaRepository<Enroll,Integer> {
}

package com.codingshuttle.collegemanagement.repository;

import com.codingshuttle.collegemanagement.entities.AdmissionRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdmissionRecordRepository extends JpaRepository<AdmissionRecord, Long> {
}
package com.chunglun.repository;

import com.chunglun.entity.MedicalRecord;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MockMedicalRecordRepository {
    private final List<MedicalRecord> medicalRecordDB = new ArrayList<>();

    public MedicalRecord insert(MedicalRecord medicalRecord) {
        medicalRecordDB.add(medicalRecord);
        return medicalRecord;
    }

    public void deleteByUserId(String userId) {
        medicalRecordDB.removeIf(p -> p.getUserId().equals(userId));
    }

    public void deleteByRecordId(String recordId) {
        medicalRecordDB.removeIf(p -> p.getRecordId().equals(recordId));
    }

    public List<MedicalRecord> findByUserId(String userId) {
        return medicalRecordDB.stream()
                .filter(p -> p.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    public Optional<MedicalRecord> findByRecordId(String recordId) {
        return medicalRecordDB.stream()
                .filter(p -> p.getRecordId().equals(recordId))
                .findFirst();
    }
}

package com.chunglun.repository;

import com.chunglun.entity.MedicalRecord;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MockMedicalRecordRepository {
    private final List<MedicalRecord> medicalRecordDB = new ArrayList<>();

    @PostConstruct
    private void initDB() {
        medicalRecordDB.add(new MedicalRecord("000138000465688", "20230710", 83, 15, 0.9, 26));
        medicalRecordDB.add(new MedicalRecord("000138000465688", "20221225", 90, 15, 0.9, 24));
    }

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

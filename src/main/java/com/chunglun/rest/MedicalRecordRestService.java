package com.chunglun.rest;

import com.chunglun.entity.MedicalRecord;
import com.chunglun.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/record", produces = MediaType.APPLICATION_JSON_VALUE)
public class MedicalRecordRestService {
    @Autowired
    private MedicalRecordService medicalRecordService;

    @GetMapping("/getByRecordId/{recordId}")
    public ResponseEntity<MedicalRecord> getMedicalRecordByRecordId(@PathVariable("recordId") String recordId) {
        MedicalRecord medicalRecord = medicalRecordService.getMedicalRecordByRecordId(recordId);
        return ResponseEntity.ok(medicalRecord);
    }

    @GetMapping("/getByUserId/{userId}")
    public ResponseEntity<List<MedicalRecord>> getMedicalRecordByUserId(@PathVariable("userId") String userId) {
        List<MedicalRecord> medicalRecords = medicalRecordService.getMedicalRecordByUserId(userId);
        return ResponseEntity.ok(medicalRecords);
    }
}

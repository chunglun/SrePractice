package com.chunglun.service;

import com.chunglun.entity.MedicalRecord;
import com.chunglun.object.NotFoundException;
import com.chunglun.object.UnprocessableEntityException;
import com.chunglun.repository.MockMedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//import static java.lang.StringTemplate.STR;

@Service
public class MedicalRecordService {
    @Autowired
    private MockMedicalRecordRepository medicalRecordRepository;

    public MedicalRecord createMedicalRecord(MedicalRecord request) {
        boolean isRecordIdDuplicated = medicalRecordRepository.findByRecordId(request.getRecordId()).isPresent();
        if (isRecordIdDuplicated) {
            throw new UnprocessableEntityException("The id of the record is duplicated.");
        }
        MedicalRecord medicalRecord = new MedicalRecord(request);
        return medicalRecordRepository.insert(medicalRecord);
    }

    public MedicalRecord getMedicalRecordByRecordId(String recordId) {
        return medicalRecordRepository.findByRecordId(recordId)
                .orElseThrow(() -> new NotFoundException("Can't find medical record with record id " + recordId + "."));
        /*return medicalRecordRepository.findByRecordId(recordId)
                .orElseThrow(() -> new NotFoundException(STR."Can't find medical record with record id \{ recordId }."));*/
    }

    public List<MedicalRecord> getMedicalRecordByUserId(String userId) {
        List<MedicalRecord> medicalRecords = medicalRecordRepository.findByUserId(userId);
        if ((medicalRecords == null) || (medicalRecords.size() == 0)) {
            throw new NotFoundException("Can't find medical record with user id " + userId + ".");
            //throw new NotFoundException(STR."Can't find medical record with user id \{ userId }.");
        }
        return medicalRecords;
    }

    public void deleteMedicalRecordByRecordId(String recordId) {
        MedicalRecord medicalRecord = this.getMedicalRecordByRecordId(recordId);
        medicalRecordRepository.deleteByRecordId(medicalRecord.getRecordId());
    }

    public void deleteMedicalRecordByUserId(String userId) {
        List<MedicalRecord> medicalRecords = this.getMedicalRecordByUserId(userId);
        medicalRecordRepository.deleteByUserId(userId);
    }
}

package com.chunglun.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicalRecord {
    private String userId;
    private String recordId;
    private Integer glu;
    private Integer sdma;
    private Double crea;
    private Integer bun;

    public MedicalRecord(MedicalRecord medicalRecord) {
        this(medicalRecord.getUserId(), medicalRecord.getRecordId(), medicalRecord.getGlu(),
                medicalRecord.getSdma(), medicalRecord.getCrea(), medicalRecord.getBun());
    }
}

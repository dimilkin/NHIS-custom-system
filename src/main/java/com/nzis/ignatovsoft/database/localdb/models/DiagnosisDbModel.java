package com.nzis.ignatovsoft.database.localdb.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "diagnosis")
public class DiagnosisDbModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "icd_code")
    private String ICDCode;
    @Column(name = "additional_icd_code")
    private String additionalICDCode;
    private String diagnosisUse;
    private String diagnosisRank;
    private String clinicalStatus;
    private String verificationStatus;
    private LocalDate onsetDateTime;
    private String notes;

    @OneToOne(mappedBy = "diagnosis", cascade = CascadeType.ALL)
    private ExamDbModel exam;
}

package com.nzis.ignatovsoft.models.closeexam;

import java.time.LocalDateTime;

public class Examination {
    private String nrnExamination;
    private String basedOn;
    private boolean isSecondary;
    private String purpose;
    private MotherHealthcare motherHealthcare;
    private ChildHealthcare childHealthcare;
    private boolean adverseConditions;
    private boolean incidentalVisit;
    private String medicalHistory;
    private String objectiveCondition;
    private String assessment;
    private String therapy;
    private Documents documents;
    private Diagnosis diagnosis;
    private Comorbidity comorbidity;
    private DiagnosticReport diagnosticReport;
    private LocalDateTime closeDate;
    // getters and setters
}
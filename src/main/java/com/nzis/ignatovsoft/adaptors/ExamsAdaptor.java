package com.nzis.ignatovsoft.adaptors;

import com.nzis.ignatovsoft.dtos.ExamDTO;
import com.nzis.ignatovsoft.dtos.PatientDTO;
import com.nzis.ignatovsoft.nhis.services.NetworkService;
import com.nzis.ignatovsoft.nhis.services.NetworkServiceImpl;

public class ExamsAdaptor {

    private final NetworkService networkService;

    public ExamsAdaptor() {
        this.networkService = new NetworkServiceImpl();
    }

    public void sendExamToNhis() {

        PatientDTO patientDTO = generatePatientDto();
        String nrn = networkService.sendExaminationOpenRequestX001(patientDTO);
        ExamDTO examDTO = generateExamDto(nrn);
        String result = networkService.sendExaminationCloseRequestX003(examDTO);
        System.out.println(result);
    }

    private PatientDTO generatePatientDto() {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setIdentifierType("1");
        patientDTO.setIdentifierValue("9101127242");
        patientDTO.setBirthDay("1991-01-12T17:05:45.678Z");
        patientDTO.setGender("1");
        patientDTO.setFirstName("Димитър");
        patientDTO.setLastname("Милкин");
        patientDTO.setAddressCountry("BG");
        patientDTO.setAddressCounty("SFO");
        patientDTO.setAddressCity("Sofia");



        return patientDTO;
    }

    private ExamDTO generateExamDto(String nrn) {
        ExamDTO examDTO = new ExamDTO();

        examDTO.setNrnExamination(nrn);
        examDTO.setICDCode("O30.0");
        examDTO.setDiagnosisUse("3");
        examDTO.setDiagnosisRank(1);
        examDTO.setClinicalStatus("10");
        examDTO.setVerificationStatus("20");
        examDTO.setNotes("notes");
        examDTO.setSecondaryField(false);
        examDTO.setPurposeField("1");
        examDTO.setGestationalWeekField(12);
        examDTO.setPregnantField(true);
        examDTO.setBreastFeedingField(false);
//        examDTO.setExamStatusField("30");
        examDTO.setMedicalHistory("Some test medical history");
        examDTO.setObjectiveCondition("Some test objective condition");
        examDTO.setConclusion("4");
        examDTO.setDischargeDisposition("1");


        return examDTO;
    }
}

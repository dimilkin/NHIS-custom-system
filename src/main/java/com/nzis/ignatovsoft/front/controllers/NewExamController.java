package com.nzis.ignatovsoft.front.controllers;

import com.nzis.ignatovsoft.dtos.ExamDTO;
import com.nzis.ignatovsoft.dtos.PatientDTO;
import com.nzis.ignatovsoft.nhis.services.NetworkService;
import com.nzis.ignatovsoft.nhis.services.NetworkServiceImpl;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.math.BigInteger;
import java.net.URL;
import java.util.ResourceBundle;

public class NewExamController implements Initializable {
    public TextField ICDCode;
    public TextField additionalIcdCode;
    public TextField diagnosisUse;
    public TextField diagnosisRank;
    public TextField clinicalStatus;
    public TextField verificationStatus;
    public TextField notes;
    public CheckBox isSecondaryField;
    public TextField purposeField;
    public TextField gestationalWeekField;
    public CheckBox isPregnantField;
    public CheckBox isBreastFeedingField;
    public TextField examStatusField;
    public Button saveExamButton;

    NetworkService networkService;

    public NewExamController() {
        this.networkService = new NetworkServiceImpl();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        saveExamButton.setOnAction(e -> {
            sendExamData();
        });
    }

    private void sendExamData() {
        PatientDTO patientDTO = generatePatientDTO();
        String nrn = networkService.sendExaminationOpenRequestX001(patientDTO);
        ExamDTO examDTO = generateExamDTO(nrn);
        examDTO.setNrnExamination(nrn);
        networkService.sendExaminationCloseRequestX003(examDTO);
    }

    private ExamDTO generateExamDTO(String nrn) {
        ExamDTO examDTO = new ExamDTO();

        examDTO.setNrnExamination(nrn);
        examDTO.setICDCode("O30.0");
        examDTO.setDiagnosisUse("3");
        examDTO.setDiagnosisRank(BigInteger.ONE);
        examDTO.setClinicalStatus("10");
        examDTO.setVerificationStatus("20");
        examDTO.setNotes("notes");
        examDTO.setSecondaryField(false);
        examDTO.setPurposeField("1");
        examDTO.setGestationalWeekField(BigInteger.valueOf(12));
        examDTO.setPregnantField(true);
        examDTO.setBreastFeedingField(false);

        return examDTO;
    }

    private PatientDTO generatePatientDTO() {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setIdentifierType("1");
        patientDTO.setIdentifierValue("9101127242");
        patientDTO.setBirthDay("1991-01-12T17:05:45.678Z");
        patientDTO.setGender("1");
        patientDTO.setFirstName("Димитър");
        patientDTO.setLastname("Милкин");
        patientDTO.setAddressCountry("BG");
        patientDTO.setAddressCounty("SOF");
        patientDTO.setAddressCity("Sofia");
        return patientDTO;
    }
}

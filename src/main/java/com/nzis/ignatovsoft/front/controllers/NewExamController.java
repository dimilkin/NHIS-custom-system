package com.nzis.ignatovsoft.front.controllers;

import com.nzis.ignatovsoft.dataservices.ExamsDataService;
import com.nzis.ignatovsoft.dataservices.PatientsDataService;
import com.nzis.ignatovsoft.dtos.ExamDTO;
import com.nzis.ignatovsoft.dtos.PatientDTO;
import com.nzis.ignatovsoft.exceptions.NHISErrorException;
import com.nzis.ignatovsoft.exceptions.NoEntityFoundException;
import com.nzis.ignatovsoft.nhis.models.nhis.nomenclatures.c002.Entry;
import com.nzis.ignatovsoft.nhis.models.nhis.x002.ContentsX002;
import com.nzis.ignatovsoft.nhis.services.NetworkService;
import com.nzis.ignatovsoft.nhis.services.NetworkServiceImpl;
import com.nzis.ignatovsoft.nhis.services.NomenclatureService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.math.BigInteger;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.nzis.ignatovsoft.NomeConstants.*;

public class NewExamController implements Initializable {
    public ComboBox<Entry> ICDCode;
    public ComboBox<Entry> additionalIcdCode;
    public ComboBox<Entry> diagnosisUse;
    public TextField diagnosisRank;
    public ComboBox<Entry> clinicalStatus;
    public ComboBox<Entry> verificationStatus;
    public TextField notes;
    public CheckBox isSecondaryField;
    public ComboBox<Entry> purposeField;
    public TextField gestationalWeekField;
    public CheckBox isPregnantField;
    public CheckBox isBreastFeedingField;
    public TextField examStatusField;
    public Button saveExamButton;
    public TextField patientIdentifierValue;

    private final NetworkService networkService;
    private final PatientsDataService patientsDataService;
    private final ExamsDataService examsDataService;

    public NewExamController() {
        this.networkService = new NetworkServiceImpl();
        this.patientsDataService = new PatientsDataService();
        examsDataService = new ExamsDataService();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        new Thread(() -> {
            ICDCode.setItems(getIcdValues(ICD_CODES));
            diagnosisUse.setItems(getNomenclatures(DIAGNOSIS_USE));
            additionalIcdCode.setItems(getIcdValues(ICD_CODES));
            clinicalStatus.setItems(getNomenclatures(DIAGNOSIS_CLINICAL_STATUS));
            verificationStatus.setItems(getNomenclatures(DIAGNOSIS_VERIFICATION_STATUS));
//            purposeField.setItems(getNomenclatures(DIAGNOSIS_PURPOSE_FIELD));
        }).start();
        saveExamButton.setOnAction(e -> {
            sendExamData(patientIdentifierValue.getText());
        });
    }

    private void sendExamData(String patientIdentifierValue) {
        try {
            checkDataForErrors();
            saveExamButton.setDisable(true);
            PatientDTO patientDTO = generatePatientDTO(patientIdentifierValue);
            ContentsX002 contentsX002 = networkService.sendExaminationOpenRequestX001(patientDTO);
            ExamDTO examDTO = generateExamDTO(contentsX002);
            int response = networkService.sendExaminationCloseRequestX003(examDTO);
            examDTO.setExamNHISStatusCode(response);
            examsDataService.saveExam(examDTO, patientIdentifierValue);
            JOptionPane.showMessageDialog(null, "Изследването е записано успешно", "Успех", JOptionPane.INFORMATION_MESSAGE);
            resetFields();
        } catch (NoEntityFoundException e) {
            JOptionPane.showMessageDialog(null, "Не е намерен пациент със зададеното ЕГН", "Грешка", JOptionPane.ERROR_MESSAGE);
            saveExamButton.setDisable(false);
        } catch (IllegalArgumentException | NHISErrorException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Грешка", JOptionPane.ERROR_MESSAGE);
            saveExamButton.setDisable(false);
        }
    }

    private ExamDTO generateExamDTO(ContentsX002 contentsX002) {
        ExamDTO examDTO = new ExamDTO();

        examDTO.setNrnExamination(contentsX002.getNrnExamination().getValue());
        examDTO.setLrnExamination(contentsX002.getLrn().getValue());
        examDTO.setICDCode(ICDCode.getValue().getKey().getValue());
        examDTO.setAdditionalIcdCode(additionalIcdCode.getValue() != null? additionalIcdCode.getValue().getKey().getValue() : null);
        examDTO.setDiagnosisUse(diagnosisUse.getValue().getKey().getValue());
        examDTO.setDiagnosisRank(new BigInteger(diagnosisRank.getText()));
        examDTO.setClinicalStatus(clinicalStatus.getValue().getKey().getValue());
        examDTO.setVerificationStatus(verificationStatus.getValue().getKey().getValue());
        examDTO.setNotes(notes.getText());
        examDTO.setSecondaryField(isSecondaryField.isSelected());
        examDTO.setPurposeField("4");
        examDTO.setGestationalWeekField(new BigInteger(gestationalWeekField.getText()));
        examDTO.setPregnantField(isPregnantField.isSelected());
        examDTO.setBreastFeedingField(isBreastFeedingField.isSelected());

        return examDTO;
    }

    private PatientDTO generatePatientDTO(String patientIdentifierValue) throws NoEntityFoundException {
        return patientsDataService.getPatientByIdentifierValue(patientIdentifierValue);
    }

    private ObservableList<Entry> getIcdValues(String code) {
        String regexO = "O([0-9]{2}|[0-9]{1,2}\\.\\d)";
        Pattern patternO = Pattern.compile(regexO);
        Predicate<String> matchesPatternO = patternO.asPredicate();


        String regexZ = "Z3[0-9](\\.\\d)?";
        Pattern patternZ = Pattern.compile(regexZ);
        Predicate<String> matchesPatternZ = patternZ.asPredicate();

        List<Entry> filteredEntries = fetchNomenclatures(code).stream()
                .filter(entry -> matchesPatternO.test(entry.getKey().getValue()) || matchesPatternZ.test(entry.getKey().getValue()))
                .collect(Collectors.toList());
        return FXCollections.observableArrayList(filteredEntries);
    }

    private ObservableList<Entry> getNomenclatures(String code) {
        return FXCollections.observableArrayList(fetchNomenclatures(code));
    }

    private List<Entry> fetchNomenclatures(String nome) {
        return NomenclatureService.getInstance().getNomenclaturesForCode(nome);
    }

    private void checkDataForErrors() {
        if (ICDCode.getValue() == null) {
            throw new IllegalArgumentException("ICD Code is required");
        }
//        if (additionalIcdCode.getValue() == null) {
//            throw new IllegalArgumentException("Additional ICD Code is required");
//        }
        if (diagnosisUse.getValue() == null) {
            throw new IllegalArgumentException("Diagnosis Use is required");
        }
        if (diagnosisRank.getText().isEmpty()) {
            throw new IllegalArgumentException("Diagnosis Rank is required");
        }
        if (clinicalStatus.getValue() == null) {
            throw new IllegalArgumentException("Clinical Status is required");
        }
        if (verificationStatus.getValue() == null) {
            throw new IllegalArgumentException("Verification Status is required");
        }
        if (notes.getText().isEmpty()) {
            throw new IllegalArgumentException("Notes are required");
        }
//        if (purposeField.getValue() == null) {
//            throw new IllegalArgumentException("Purpose Field is required");
//        }
        if (gestationalWeekField.getText().isEmpty()) {
            throw new IllegalArgumentException("Gestational Week Field is required");
        }
        if (examStatusField.getText().isEmpty()) {
            throw new IllegalArgumentException("Exam Status Field is required");
        }
        if (patientIdentifierValue.getText().isEmpty()) {
            throw new IllegalArgumentException("Patient Identifier Value is required");
        }
    }

    private void resetFields() {
        ICDCode.setValue(null);
        additionalIcdCode.setValue(null);
        diagnosisUse.setValue(null);
        diagnosisRank.setText("");
        clinicalStatus.setValue(null);
        verificationStatus.setValue(null);
        notes.setText("");
        isSecondaryField.setSelected(false);
        purposeField.setValue(null);
        gestationalWeekField.setText("");
        isPregnantField.setSelected(false);
        isBreastFeedingField.setSelected(false);
        examStatusField.setText("");
        patientIdentifierValue.setText("");
        saveExamButton.setDisable(false);
    }
}

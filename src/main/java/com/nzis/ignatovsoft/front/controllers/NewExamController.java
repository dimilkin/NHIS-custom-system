package com.nzis.ignatovsoft.front.controllers;

import com.nzis.ignatovsoft.dtos.ExamDTO;
import com.nzis.ignatovsoft.dtos.PatientDTO;
import com.nzis.ignatovsoft.nhis.models.nhis.nomenclatures.c002.Entry;
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

    NetworkService networkService;

    public NewExamController() {
        this.networkService = new NetworkServiceImpl();
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
//            sendExamData();
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
        examDTO.setICDCode("Z34");
        examDTO.setAdditionalIcdCode("Z34.0");
        examDTO.setDiagnosisUse("3");
        examDTO.setDiagnosisRank(BigInteger.ONE);
        examDTO.setClinicalStatus("10");
        examDTO.setVerificationStatus("20");
        examDTO.setNotes("notes");
        examDTO.setSecondaryField(false);
        examDTO.setPurposeField("4");
        examDTO.setGestationalWeekField(BigInteger.valueOf(24));
        examDTO.setPregnantField(true);
        examDTO.setBreastFeedingField(false);

        return examDTO;
    }

    private PatientDTO generatePatientDTO() {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setIdentifierType("1");
        patientDTO.setIdentifierValue("9412126531");
        patientDTO.setBirthDay("1994-12-12T17:05:45.678Z");
        patientDTO.setGender("2");
        patientDTO.setFirstName("Косара");
        patientDTO.setLastname("Милкина");
        patientDTO.setAddressCountry("BG");
        patientDTO.setAddressCounty("SOF");
        patientDTO.setAddressCity("Sofia");
        return patientDTO;
    }

    private ObservableList<Entry> getIcdValues(String code) {
        String regex = "O([0-9]{2}|[0-9]{1,2}\\.\\d)";
        Pattern pattern = Pattern.compile(regex);
        Predicate<String> matchesPattern = pattern.asPredicate();

        List<Entry> filteredEntries = fetchNomenclatures(code).stream()
                .filter(entry -> matchesPattern.test(entry.getKey().getValue()))
                .collect(Collectors.toList());
        return FXCollections.observableArrayList(filteredEntries);
    }

    private ObservableList<Entry> getNomenclatures(String code) {
        return FXCollections.observableArrayList(fetchNomenclatures(code));
    }

    private List<Entry> fetchNomenclatures(String nome) {
        return NomenclatureService.getInstance().getNomenclaturesForCode(nome);
    }
}

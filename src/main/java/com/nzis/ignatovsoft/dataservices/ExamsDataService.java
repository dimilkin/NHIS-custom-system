package com.nzis.ignatovsoft.dataservices;

import com.nzis.ignatovsoft.database.localdb.models.DiagnosisDbModel;
import com.nzis.ignatovsoft.database.localdb.models.ExamDbModel;
import com.nzis.ignatovsoft.database.localdb.models.PatientDbModel;
import com.nzis.ignatovsoft.database.localdb.repos.ExamsRepo;
import com.nzis.ignatovsoft.database.localdb.repos.impls.DiagnosisRepoImpl;
import com.nzis.ignatovsoft.database.localdb.repos.impls.ExamsRepoImpls;
import com.nzis.ignatovsoft.dtos.ExamDTO;
import com.nzis.ignatovsoft.exceptions.NoEntityFoundException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ExamsDataService {


    private final ObservableList<ExamDbModel> allExamsFromLocalDb = FXCollections.observableArrayList();
    private final ExamsRepo examRepo;
    private final DiagnosisDataService diagnosisDataService;
    private final PatientsDataService patientsDataService;

    public ExamsDataService() {
        examRepo = new ExamsRepoImpls();
        diagnosisDataService = new DiagnosisDataService(new DiagnosisRepoImpl());
        patientsDataService = new PatientsDataService();
        loadData();
    }

    public ObservableList<ExamDbModel> getAllLocalDbExams() {
        return allExamsFromLocalDb;
    }

    private void loadData() {
        allExamsFromLocalDb.addAll(examRepo.getAllExamsFromDatabase());
    }

    public ObservableList<ExamDbModel> getFilteredExams(LocalDate startDate, LocalDate endDate) {
        return FXCollections.observableArrayList(examRepo.getFilteredExams(startDate, endDate));
    }

    public ObservableList<ExamDbModel> getFilteredExams(LocalDate startDate, LocalDate endDate, String identifierValue) {
        List<ExamDbModel> filteredExamsByDate = examRepo.getFilteredExams(startDate, endDate);
        List<ExamDbModel> filteredExamsByIdentifier = filteredExamsByDate.stream()
                .filter(exam -> exam.getPatient().getIdentifier().equals(identifierValue))
                .collect(Collectors.toList());
        return FXCollections.observableArrayList(filteredExamsByIdentifier);
    }

    public ObservableList<ExamDbModel> getFilteredExamsByIdentifier(String identifierValue) {
        return FXCollections.observableArrayList(examRepo.getFilteredExamsByIdentifier(identifierValue));
    }

    public void saveExam(ExamDTO examDTO, String patientIdentifierValue) throws NoEntityFoundException {
        try {
            ExamDbModel examDbModel = mapExamDtoToExamDbModel(examDTO);
            DiagnosisDbModel diagnosisDbModel = mapExamDtoToDiiagnosisDbModel(examDTO);
            examDbModel.setDiagnosis(diagnosisDbModel);
            PatientDbModel patientDbModel = patientsDataService.getPatientDbModelByIdentifierValue(patientIdentifierValue);
            examDbModel.setPatient(patientDbModel);
            examRepo.saveExam(examDbModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ExamDbModel mapExamDtoToExamDbModel(ExamDTO examDTO) {
        ExamDbModel examDbModel = new ExamDbModel();
        examDbModel.setLrn(examDTO.getLrnExamination());
        examDbModel.setNrn(examDTO.getNrnExamination());
        examDbModel.setSecondary(examDTO.isSecondaryField());
        examDbModel.setCloseDate(LocalDateTime.now());
        examDbModel.setPurpose(examDTO.getPurposeField());
        examDbModel.setGestationalWeek(examDTO.getGestationalWeekField().toString());
        examDbModel.setPregnant(examDTO.isPregnantField());
        examDbModel.setBreastFeeding(examDTO.isBreastFeedingField());
        examDbModel.setExamStatus(examDTO.getExamStatusField());
        examDbModel.setExamNHISStatusCode(examDTO.getExamNHISStatusCode());

        return examDbModel;
    }

    private DiagnosisDbModel mapExamDtoToDiiagnosisDbModel(ExamDTO examDTO) {
        DiagnosisDbModel diagnosisDbModel = new DiagnosisDbModel();
        diagnosisDbModel.setICDCode(examDTO.getICDCode());
        diagnosisDbModel.setAdditionalICDCode(examDTO.getAdditionalIcdCode());
        diagnosisDbModel.setDiagnosisUse(examDTO.getDiagnosisUse());
        diagnosisDbModel.setDiagnosisRank(examDTO.getDiagnosisRank().toString());
        diagnosisDbModel.setClinicalStatus(examDTO.getClinicalStatus());
        diagnosisDbModel.setVerificationStatus(examDTO.getVerificationStatus());
        diagnosisDbModel.setOnsetDateTime(LocalDate.now());
        diagnosisDbModel.setNotes(examDTO.getNotes());
        return diagnosisDbModel;
    }
}

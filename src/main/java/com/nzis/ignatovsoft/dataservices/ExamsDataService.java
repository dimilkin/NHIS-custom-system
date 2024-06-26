package com.nzis.ignatovsoft.dataservices;

import com.nzis.ignatovsoft.database.localdb.models.ExamDbModel;
import com.nzis.ignatovsoft.database.localdb.repos.ExamsRepo;
import com.nzis.ignatovsoft.database.localdb.repos.impls.ExamsRepoImpls;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ExamsDataService {


    private final ObservableList<ExamDbModel> allExamsFromLocalDb = FXCollections.observableArrayList();
    ExamsRepo examRepo;

    public ExamsDataService() {
        examRepo = new ExamsRepoImpls();
        loadData();
    }

    public void saveExam(ExamDbModel examDbModel) {
        examRepo.saveExam(examDbModel);
        allExamsFromLocalDb.add(examDbModel);
    }

    public ExamDbModel getExamByNrnValue(String nrnValue) {
        return examRepo.getExamByNrnValue(nrnValue);
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
}

package com.nzis.ignatovsoft.dataservices;

import com.nzis.ignatovsoft.database.localdb.models.ExamDbModel;
import com.nzis.ignatovsoft.database.localdb.repos.ExamsRepo;
import com.nzis.ignatovsoft.database.localdb.repos.impls.ExamsRepoImpls;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ExamsDataService {


    private final ObservableList<ExamDbModel> allExamsFromLocalDb = FXCollections.observableArrayList();
    ExamsRepo examRepo;

    public ExamsDataService() {
        examRepo = new ExamsRepoImpls();
        loadData();
    }

    public ObservableList<ExamDbModel> getAllLocalDbExams() {
        return allExamsFromLocalDb;
    }

    private void loadData() {
        allExamsFromLocalDb.addAll(examRepo.getAllExamsFromDatabase());
    }

}

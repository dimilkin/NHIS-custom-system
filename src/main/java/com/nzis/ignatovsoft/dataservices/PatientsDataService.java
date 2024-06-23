package com.nzis.ignatovsoft.dataservices;

import com.nzis.ignatovsoft.database.astraiadb.repos.AstraiaPatientsRepo;
import com.nzis.ignatovsoft.database.astraiadb.repos.AstraiaPatientsRepoImpl;
import com.nzis.ignatovsoft.database.localdb.models.PatientDbModel;
import com.nzis.ignatovsoft.database.localdb.repos.PatientRepo;
import com.nzis.ignatovsoft.database.localdb.repos.impls.PatientsRepoImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PatientsDataService {

    private final ObservableList<PatientDbModel> allPatientsFromLocalDb = FXCollections.observableArrayList();
    PatientRepo patientRepo;
    AstraiaPatientsRepo astraiaPatientsRepo;

    public PatientsDataService() {
        patientRepo = new PatientsRepoImpl();
        astraiaPatientsRepo = new AstraiaPatientsRepoImpl();
        loadData();
    }
    public ObservableList<PatientDbModel> getAllLocalDbPatients() {
        return allPatientsFromLocalDb;
    }

    private void loadData() {
        allPatientsFromLocalDb.addAll(patientRepo.getAllPatientsFromDatabase());
    }
}

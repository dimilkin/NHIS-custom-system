package com.nzis.ignatovsoft.dataservices;

import com.nzis.ignatovsoft.database.astraiadb.repos.AstraiaPatientsRepo;
import com.nzis.ignatovsoft.database.astraiadb.repos.AstraiaPatientsRepoImpl;
import com.nzis.ignatovsoft.database.localdb.models.PatientDbModel;
import com.nzis.ignatovsoft.database.localdb.repos.PatientRepo;
import com.nzis.ignatovsoft.database.localdb.repos.impls.PatientsRepoImpl;
import com.nzis.ignatovsoft.dtos.PatientDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

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

    public void savePatient(PatientDTO patientDTO) {
        PatientDbModel patientDbModel = mapPatientDtoToPatientDbModel(patientDTO);
        patientRepo.savePatient(patientDbModel);
        allPatientsFromLocalDb.add(patientDbModel);
    }

    private PatientDbModel mapPatientDtoToPatientDbModel(PatientDTO patientDTO) {
        PatientDbModel patientDbModel = new PatientDbModel();
        patientDbModel.setIdentifierType(patientDTO.getIdentifierType());
        patientDbModel.setIdentifier(patientDTO.getIdentifierValue());
        patientDbModel.setBirthDate(LocalDate.parse(patientDTO.getBirthDay()));
        patientDbModel.setGender(patientDTO.getGender());
        patientDbModel.setFirstName(patientDTO.getFirstName());
        patientDbModel.setMiddleName(patientDTO.getMiddleName());
        patientDbModel.setLastName(patientDTO.getLastname());
        patientDbModel.setAddressCountry(patientDTO.getAddressCountry());
        patientDbModel.setAddressCounty(patientDTO.getAddressCounty());
        patientDbModel.setAddressCity(patientDTO.getAddressCity());
        return patientDbModel;
    }
}

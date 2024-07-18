package com.nzis.ignatovsoft.dataservices;

import com.nzis.ignatovsoft.database.astraiadb.repos.AstraiaPatientsRepo;
import com.nzis.ignatovsoft.database.astraiadb.repos.AstraiaPatientsRepoImpl;
import com.nzis.ignatovsoft.database.localdb.models.PatientDbModel;
import com.nzis.ignatovsoft.database.localdb.repos.PatientRepo;
import com.nzis.ignatovsoft.database.localdb.repos.impls.PatientsRepoImpl;
import com.nzis.ignatovsoft.dtos.PatientDTO;
import com.nzis.ignatovsoft.exceptions.NoEntityFoundException;
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

    public void refreshLocalDbPatients() {
        allPatientsFromLocalDb.clear();
        loadData();
    }

    private void loadData() {
        allPatientsFromLocalDb.addAll(patientRepo.getAllPatientsFromDatabase());
    }

    public boolean savePatient(PatientDTO patientDTO) {
        PatientDbModel patientDbModel = mapPatientDtoToPatientDbModel(patientDTO);
        if(patientRepo.savePatient(patientDbModel)) {
            allPatientsFromLocalDb.add(patientDbModel);
            return true;
        }
        return false;
    }

    public boolean updatePatient(PatientDTO patientDTO) {
        PatientDbModel patientDbModel = mapPatientDtoToPatientDbModel(patientDTO);
        patientDbModel.setId(patientDTO.getId());
        return patientRepo.updatePatient(patientDbModel);
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

    public PatientDTO getPatientByIdentifierValue(String patientIdentifierValue) throws NoEntityFoundException {
        PatientDbModel patientDbModel = patientRepo.getPatientByIdentifierValue(patientIdentifierValue);
        return mapPatientDbModelToPatientDto(patientDbModel);
    }

    public PatientDbModel getPatientDbModelByIdentifierValue(String patientIdentifierValue) throws NoEntityFoundException {
        PatientDbModel patientDbModel = patientRepo.getPatientByIdentifierValue(patientIdentifierValue);
        return patientDbModel;
    }

    private PatientDTO mapPatientDbModelToPatientDto(PatientDbModel patientDbModel) {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setId(patientDbModel.getId());
        patientDTO.setIdentifierType(patientDbModel.getIdentifierType());
        patientDTO.setIdentifierValue(patientDbModel.getIdentifier());
        patientDTO.setBirthDay(patientDbModel.getBirthDate().toString());
        patientDTO.setGender(patientDbModel.getGender());
        patientDTO.setFirstName(patientDbModel.getFirstName());
        patientDTO.setMiddleName(patientDbModel.getMiddleName());
        patientDTO.setLastname(patientDbModel.getLastName());
        patientDTO.setAddressCountry(patientDbModel.getAddressCountry());
        patientDTO.setAddressCounty(patientDbModel.getAddressCounty());
        patientDTO.setAddressCity(patientDbModel.getAddressCity());
        return patientDTO;
    }
}

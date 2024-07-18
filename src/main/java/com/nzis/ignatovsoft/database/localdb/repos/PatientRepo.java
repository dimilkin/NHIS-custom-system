package com.nzis.ignatovsoft.database.localdb.repos;

import com.nzis.ignatovsoft.database.localdb.models.PatientDbModel;
import com.nzis.ignatovsoft.exceptions.NoEntityFoundException;

import java.util.List;

public interface PatientRepo {

    List<PatientDbModel> getAllPatientsFromDatabase();

    boolean savePatient(PatientDbModel patientDbModel);

    PatientDbModel getPatientByIdentifierValue(String patientIdentifierValue) throws NoEntityFoundException;

    boolean updatePatient(PatientDbModel patientDbModel);
}

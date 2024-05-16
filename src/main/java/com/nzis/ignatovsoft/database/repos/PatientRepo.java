package com.nzis.ignatovsoft.database.repos;

import com.nzis.ignatovsoft.database.models.PatientDbModel;

import java.util.List;

public interface PatientRepo {

    List<PatientDbModel> getAllPatientsFromDatabase();
}

package com.nzis.ignatovsoft.database.localdb.repos;

import com.nzis.ignatovsoft.database.localdb.models.PatientDbModel;

import java.util.List;

public interface PatientRepo {

    List<PatientDbModel> getAllPatientsFromDatabase();
}

package com.nzis.ignatovsoft.database.astraiadb.repos;

import com.nzis.ignatovsoft.database.astraiadb.models.AstraiaPatient;

import java.util.List;

public interface AstraiaPatientsRepo {
    List<AstraiaPatient> getAllPatientsFromAstraiaDatabase();
}

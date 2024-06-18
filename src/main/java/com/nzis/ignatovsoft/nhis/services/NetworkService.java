package com.nzis.ignatovsoft.nhis.services;

import com.nzis.ignatovsoft.dtos.PatientDTO;

public interface NetworkService {

    String sendExaminationOpenRequest (PatientDTO patientDTO);

    String sendExaminationCloseRequest (PatientDTO patientDTO);
}

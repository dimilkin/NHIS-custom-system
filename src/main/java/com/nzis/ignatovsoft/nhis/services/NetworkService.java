package com.nzis.ignatovsoft.nhis.services;

import com.nzis.ignatovsoft.dtos.PatientDTO;

public interface NetworkService {

    String sendExaminationOpenRequestX001 (PatientDTO patientDTO);

    String sendExaminationCloseRequestX003 (PatientDTO patientDTO);
}

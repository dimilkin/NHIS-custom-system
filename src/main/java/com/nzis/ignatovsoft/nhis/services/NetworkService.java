package com.nzis.ignatovsoft.nhis.services;

import com.nzis.ignatovsoft.dtos.ExamDTO;
import com.nzis.ignatovsoft.dtos.PatientDTO;
import com.nzis.ignatovsoft.nhis.models.nhis.nomenclatures.c002.Entry;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface NetworkService {

    String sendExaminationOpenRequestX001 (PatientDTO patientDTO);

    String sendExaminationCloseRequestX003 (ExamDTO ex);

    CompletableFuture<List<Entry>> getNomenclaturesC002(String name);


}

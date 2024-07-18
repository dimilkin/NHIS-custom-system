package com.nzis.ignatovsoft.nhis.services;

import com.nzis.ignatovsoft.dtos.ExamDTO;
import com.nzis.ignatovsoft.dtos.PatientDTO;
import com.nzis.ignatovsoft.nhis.models.nhis.nomenclatures.c002.Entry;
import com.nzis.ignatovsoft.nhis.models.nhis.x002.ContentsX002;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface NetworkService {

    ContentsX002 sendExaminationOpenRequestX001 (PatientDTO patientDTO);

    int sendExaminationCloseRequestX003 (ExamDTO ex);

    CompletableFuture<List<Entry>> getNomenclaturesC002(String name);


}

package com.nzis.ignatovsoft.nhis.services;

import com.nzis.ignatovsoft.dtos.ExamDTO;
import com.nzis.ignatovsoft.dtos.PatientDTO;
import com.nzis.ignatovsoft.exceptions.NHISErrorException;
import com.nzis.ignatovsoft.nhis.models.nhis.nomenclatures.c002.Entry;
import com.nzis.ignatovsoft.nhis.models.nhis.v3.x002.ContentsX002V2;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface NetworkService {

    ContentsX002V2 sendExaminationOpenRequestX001 (PatientDTO patientDTO) throws NHISErrorException;

    int sendExaminationCloseRequestX003 (ExamDTO ex) throws NHISErrorException;

    CompletableFuture<List<Entry>> getNomenclaturesC002(String name);


}

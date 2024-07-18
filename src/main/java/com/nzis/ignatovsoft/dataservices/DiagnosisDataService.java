package com.nzis.ignatovsoft.dataservices;

import com.nzis.ignatovsoft.database.localdb.models.DiagnosisDbModel;
import com.nzis.ignatovsoft.database.localdb.repos.DiagnosisRepo;

public class DiagnosisDataService {

    private final DiagnosisRepo diagnosisRepo;

    public DiagnosisDataService(DiagnosisRepo diagnosisRepo) {
        this.diagnosisRepo = diagnosisRepo;
    }

    public boolean saveDiagnosis(DiagnosisDbModel diagnosisDbModel) {
        return diagnosisRepo.saveDiagnosis(diagnosisDbModel);
    }

    public DiagnosisDbModel getDiagnosisByIdentifierValue(long diagnosisId) {
        return diagnosisRepo.getDiagnosisByIdentifierValue(diagnosisId);
    }

    public DiagnosisDbModel getDiagnosisByExamId(long examId) {
        return diagnosisRepo.getDiagnosisByExamId(examId);
    }
}

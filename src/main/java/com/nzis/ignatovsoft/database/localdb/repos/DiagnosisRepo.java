package com.nzis.ignatovsoft.database.localdb.repos;

import com.nzis.ignatovsoft.database.localdb.models.DiagnosisDbModel;

public interface DiagnosisRepo {

    boolean saveDiagnosis(DiagnosisDbModel diagnosisDbModel);

    DiagnosisDbModel getDiagnosisByIdentifierValue(long diagnosisId);

    DiagnosisDbModel getDiagnosisByExamId(long examId);
}

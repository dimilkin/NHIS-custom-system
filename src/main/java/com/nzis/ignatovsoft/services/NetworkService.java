package com.nzis.ignatovsoft.services;

import com.nzis.ignatovsoft.models.openexam.Examination;
import com.nzis.ignatovsoft.models.openexam.Subject;

public interface NetworkService {

    void sendExaminationOpenRequest (Subject patient, Examination examination);


}

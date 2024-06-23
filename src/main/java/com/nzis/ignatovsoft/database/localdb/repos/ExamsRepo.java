package com.nzis.ignatovsoft.database.localdb.repos;

import com.nzis.ignatovsoft.database.localdb.models.ExamDbModel;

import java.util.List;

public interface ExamsRepo {

    List<ExamDbModel> getAllExamsFromDatabase();
}

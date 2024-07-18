package com.nzis.ignatovsoft.database.localdb.repos;

import com.nzis.ignatovsoft.database.localdb.models.ExamDbModel;

import java.time.LocalDate;
import java.util.List;

public interface ExamsRepo {

    List<ExamDbModel> getAllExamsFromDatabase();

    List<ExamDbModel> getFilteredExams(LocalDate startDate, LocalDate endDate);

    List<ExamDbModel> getFilteredExamsByIdentifier(String identifierValue);

    void saveExam(ExamDbModel examDbModel);
}

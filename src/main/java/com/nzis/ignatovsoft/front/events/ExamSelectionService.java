package com.nzis.ignatovsoft.front.events;

import com.nzis.ignatovsoft.database.localdb.models.ExamDbModel;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class ExamSelectionService {

    private static final ExamSelectionService INSTANCE = new ExamSelectionService();
    private ObjectProperty<ExamDbModel> selectedExam;

    private ExamSelectionService() {
        selectedExam = new SimpleObjectProperty<>();
    }

    public static ExamSelectionService getInstance() {
        return INSTANCE;
    }

    public ExamDbModel getSelectedExam() {
        return selectedExam.get();
    }

    public ObjectProperty<ExamDbModel> selectedExamProperty() {
        return selectedExam;
    }

    public void setSelectedExam(ExamDbModel selectedExam) {
        this.selectedExam.set(selectedExam);
    }
}
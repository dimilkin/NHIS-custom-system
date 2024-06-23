package com.nzis.ignatovsoft.front.events;

import com.nzis.ignatovsoft.database.localdb.models.ExamDbModel;
import javafx.event.Event;
import javafx.event.EventType;

public class ExamsListCellClickEvent extends Event {

    public static final EventType<ExamsListCellClickEvent> EXAM_SELECTED = new EventType<>(Event.ANY, "EXAM_SELECTED");

    ExamDbModel examDbModel;

    public ExamsListCellClickEvent(ExamDbModel examDbModel) {
        super(EXAM_SELECTED);
        this.examDbModel = examDbModel;
    }

    public ExamDbModel getExamDbModel() {
        return examDbModel;
    }
}




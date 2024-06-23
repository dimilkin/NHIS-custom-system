package com.nzis.ignatovsoft.front.controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;

public class SideMenuController {

    private final StringProperty actionProperty = new SimpleStringProperty();

    public StringProperty actionProperty() {
        return actionProperty;
    }

    public void openStartingScreen(ActionEvent actionEvent) {
        actionProperty.set("home");
    }

    public void createNewPatient(ActionEvent actionEvent) {
        actionProperty.set("new-patiient");
    }

    public void createNewExamRecord(ActionEvent actionEvent) {
        actionProperty.set("new-exam");
    }

    public void openAllPatients(ActionEvent actionEvent) {
        actionProperty.set("all-patiients");
    }

    public void openAllExams(ActionEvent actionEvent) {
        actionProperty.set("all-exams");
    }
}

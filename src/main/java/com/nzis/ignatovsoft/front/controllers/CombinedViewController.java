package com.nzis.ignatovsoft.front.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class CombinedViewController {

    @FXML
    public BorderPane combinedView;


    public void initialize() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/SideMenu.fxml"));
        try {
            Node sideMenu = loader.load();
            SideMenuController sideMenuController = loader.getController();
            sideMenuController.actionProperty().addListener((observable, oldValue, newValue) -> {
                if ("home".equals(newValue)) {
                    setCenterView("/fxml/MainDashboard.fxml");
                }
                if ("new-exam".equals(newValue)) {
                    setCenterView("/fxml/NewExamination.fxml");
                }
                if ("new-patiient".equals(newValue)) {
                    setCenterView("/fxml/NewPatientDetails.fxml");
                }
                if ("all-patiients".equals(newValue)) {
                    setCenterView("/fxml/PatientsListDetails.fxml");
                }
                if ("all-exams".equals(newValue)) {
                    setCenterView("/fxml/ExamsList.fxml");
                }
            });
            combinedView.setLeft(sideMenu);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void setCenterView(String name) {
        try {
            Node loginView = FXMLLoader.load(getClass().getResource(name));
            combinedView.setCenter(loginView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package com.nzis.ignatovsoft.front.views;

import com.nzis.ignatovsoft.database.localdb.models.PatientDbModel;
import com.nzis.ignatovsoft.front.controllers.PatientsListCellController;
import com.nzis.ignatovsoft.front.events.PatientsListCellClickEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

import java.io.IOException;


public class PatientsCellFactory extends ListCell<PatientDbModel> {

    @Override
    protected void updateItem(PatientDbModel patientDbModel, boolean empty) {
        super.updateItem(patientDbModel, empty);
        if (empty){
            setText(null);
            setGraphic(null);
        }
        else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PatientsCell.fxml"));
            PatientsListCellController controller = new PatientsListCellController(patientDbModel);
            loader.setController(controller);
            setText(null);

            try {
                setGraphic(loader.load());
            } catch (IOException e) {
                e.printStackTrace();
            }

            setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && !isEmpty()) {
                    handleCellClick(patientDbModel);
                    fireEvent(new PatientsListCellClickEvent(patientDbModel));
                }
            });
        }
    }

    private void handleCellClick(PatientDbModel patientDbModel) {

    }
}

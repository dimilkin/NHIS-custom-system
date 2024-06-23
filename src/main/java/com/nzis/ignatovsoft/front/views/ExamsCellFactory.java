package com.nzis.ignatovsoft.front.views;

import com.nzis.ignatovsoft.database.localdb.models.ExamDbModel;
import com.nzis.ignatovsoft.front.controllers.ExamsListCellController;
import com.nzis.ignatovsoft.front.events.ExamsListCellClickEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

import java.io.IOException;

public class ExamsCellFactory extends ListCell<ExamDbModel> {

    @Override
    protected void updateItem(ExamDbModel examDbModel, boolean empty) {
        super.updateItem(examDbModel, empty);
        if (empty){
            setText(null);
            setGraphic(null);
        }
        else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ExamsListCell.fxml"));
            ExamsListCellController controller = new ExamsListCellController(examDbModel);
            loader.setController(controller);
            setText(null);

            try {
                setGraphic(loader.load());
            } catch (IOException e) {
                e.printStackTrace();
            }

            setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && !isEmpty()) {
                    handleCellClick(examDbModel);
                    fireEvent(new ExamsListCellClickEvent(examDbModel));
                }
            });
        }
    }

    private void handleCellClick(ExamDbModel examDbModel) {

    }
}

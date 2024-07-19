package com.nzis.ignatovsoft.front.views;

import com.nzis.ignatovsoft.database.localdb.models.ExamDbModel;
import com.nzis.ignatovsoft.front.controllers.TransactionCellController;
import com.nzis.ignatovsoft.front.events.TransactionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

import java.io.IOException;

public class TransactionCellFactory extends ListCell<ExamDbModel> {

    @Override
    protected void updateItem(ExamDbModel transaction, boolean empty) {
        super.updateItem(transaction, empty);
        if (empty){
            setText(null);
            setGraphic(null);
        }
        else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/TransactionCell.fxml"));
            TransactionCellController controller = new TransactionCellController(transaction);
            loader.setController(controller);
            setText(null);

            try {
                setGraphic(loader.load());
            } catch (IOException e) {
                e.printStackTrace();
            }

            setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && !isEmpty()) {
                    handleCellClick(transaction);
                    fireEvent(new TransactionEvent(transaction));
                }
            });
        }
    }

    private void handleCellClick(ExamDbModel transaction) {
    }

}

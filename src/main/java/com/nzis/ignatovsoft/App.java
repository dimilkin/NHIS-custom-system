package com.nzis.ignatovsoft;

import com.nzis.ignatovsoft.configurations.application.HibernateConfigForAstraia;
import com.nzis.ignatovsoft.configurations.application.HibernateConfigForLocalDB;
import com.nzis.ignatovsoft.database.astraiadb.trigers.DatabaseListener;
import com.nzis.ignatovsoft.database.astraiadb.trigers.TriggerCreator;
import com.nzis.ignatovsoft.database.astraiadb.trigers.TriggerFunctionCreator;
import com.nzis.ignatovsoft.nhis.services.NomenclatureService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.sql.SQLException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws SQLException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CombinedView.fxml"));
        Scene scene;

        startDbTrigers();
        listenForDBChanges();
        loadICDcodesData();

        try {
            scene = new Scene(loader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Ignatov Soft");
        stage.show();
    }

    private void loadICDcodesData() {
        new Thread(() -> {
            NomenclatureService nomenclatureService = NomenclatureService.getInstance();
            nomenclatureService.getNomenclaturesForCode(NomeConstants.ICD_CODES);
        }).start();
    }

    private void listenForDBChanges() {
        new Thread(() -> {
            DatabaseListener databaseListener = new DatabaseListener();
            try {
                databaseListener.listenForDatabaseChanges();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }).start();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        HibernateConfigForLocalDB.shutdowLocalDbSessionFactory();
        HibernateConfigForAstraia.shutdownAstraiaSessionFactory();
    }

    private void startDbTrigers() {
        Session session = HibernateConfigForAstraia.getSessionFactoryForAstraia().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Create trigger function
            TriggerFunctionCreator.createTriggerFunction(session);

            // Create trigger
            TriggerCreator.createTrigger(session);

            transaction.commit();
            System.out.println("Trigger function and trigger created successfully.");
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}


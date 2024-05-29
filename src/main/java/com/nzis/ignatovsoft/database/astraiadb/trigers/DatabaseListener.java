package com.nzis.ignatovsoft.database.astraiadb.trigers;

import org.postgresql.PGConnection;
import org.postgresql.PGNotification;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseListener {

    public DatabaseListener() {
    }

    public void listenForDatabaseChanges() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:4567/Astraia", "postgres", "milkinis");
        PGConnection pgconn = conn.unwrap(PGConnection.class);

        Statement stmt = conn.createStatement();
        stmt.execute("LISTEN notify_channel");
        stmt.close();

        while (true) {
            PGNotification[] notifications = pgconn.getNotifications();
            if (notifications != null) {
                for (PGNotification notification : notifications) {
                    System.out.println("Received notification: " + notification.getParameter());

                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
package com.nzis.ignatovsoft.database.astraiadb.trigers;

import org.hibernate.Session;

@SuppressWarnings("SqlNoDataSourceInspection")
public class TriggerCreator {
    public static void createTrigger(Session session) {
        String createTriggerSQL =
                "SET search_path to local;" +
                        "CREATE TRIGGER patients_insert_trigger " +
                        "AFTER INSERT ON patients " +
                        "FOR EACH ROW " +
                        "EXECUTE FUNCTION notify_on_insert();";

        session.createNativeQuery(createTriggerSQL, String.class).executeUpdate();
    }
}

package com.nzis.ignatovsoft.database.astraiadb.trigers;

import org.hibernate.Session;

@SuppressWarnings("SqlNoDataSourceInspection")
public class TriggerFunctionCreator {
    public static void createTriggerFunction(Session session) {
        String createFunctionSQL =  "SET search_path to healthcare;" +
                "CREATE OR REPLACE FUNCTION notify_on_insert() RETURNS TRIGGER AS $$" +
                "BEGIN " +
                "  RAISE NOTICE 'A new record with ID % has been inserted into the patients table.', NEW.id; " +
                "  PERFORM pg_notify('notify_channel', 'A new record with ID ' || NEW.id || ' has been inserted into the patients table.'); " +
                "  RETURN NEW;" +
                "END; " +
                "$$ LANGUAGE plpgsql;";

        session.createNativeQuery(createFunctionSQL, String.class).executeUpdate();
    }
}

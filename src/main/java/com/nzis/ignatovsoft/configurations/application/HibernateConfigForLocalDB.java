package com.nzis.ignatovsoft.configurations.application;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

import static com.nzis.ignatovsoft.Constants.XML_CONFIG_LOCAL_DB;

public class HibernateConfigForLocalDB {
    private static SessionFactory sessionFactoryForLocalDB;
    private static File xmlConfigFile = new File(XML_CONFIG_LOCAL_DB);

    private static SessionFactory buildSessionFactoryForLocalDB() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure(xmlConfigFile).buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactoryForLocalDB() {
        if (sessionFactoryForLocalDB == null){
            sessionFactoryForLocalDB = buildSessionFactoryForLocalDB();
        }
        return sessionFactoryForLocalDB;
    }

    public static void shutdowLocalDbSessionFactory() {
        getSessionFactoryForLocalDB().close();
    }
}

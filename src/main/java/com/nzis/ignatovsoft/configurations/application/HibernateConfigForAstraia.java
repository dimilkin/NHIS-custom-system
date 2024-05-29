package com.nzis.ignatovsoft.configurations.application;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

import static com.nzis.ignatovsoft.Constants.XML_CONFIG_ASTRAIA;

public class HibernateConfigForAstraia {
    private static SessionFactory sessionFactoryForAstraia;
    private static File xmlConfigFile = new File(XML_CONFIG_ASTRAIA);

    private static SessionFactory buildSessionFactoryForAstraia() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure(xmlConfigFile).buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactoryForAstraia() {
        if (sessionFactoryForAstraia == null){
            sessionFactoryForAstraia = buildSessionFactoryForAstraia();
        }
        return sessionFactoryForAstraia;
    }

    public static void shutdownAstraiaSessionFactory() {
        getSessionFactoryForAstraia().close();
    }
}

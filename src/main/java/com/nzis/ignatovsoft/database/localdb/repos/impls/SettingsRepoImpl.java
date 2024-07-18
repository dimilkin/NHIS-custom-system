package com.nzis.ignatovsoft.database.localdb.repos.impls;

import com.nzis.ignatovsoft.configurations.application.HibernateConfigForLocalDB;
import com.nzis.ignatovsoft.database.localdb.models.PracticeInfo;
import com.nzis.ignatovsoft.database.localdb.repos.SettingsRepo;
import org.hibernate.Session;

public class SettingsRepoImpl implements SettingsRepo {

    @Override
    public void saveSettings(PracticeInfo practiceInfo) {
        Session session = null;
        try {
            session = HibernateConfigForLocalDB.getSessionFactoryForLocalDB().openSession();
            session.beginTransaction();
            session.merge(practiceInfo);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();  // Log the exception
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public PracticeInfo getSettings() {
        try (Session session = HibernateConfigForLocalDB.getSessionFactoryForLocalDB().openSession()) {
            return session.createQuery("FROM PracticeInfo", PracticeInfo.class).uniqueResult();
        }
    }

    @Override
    public PracticeInfo getSettingsById(long id) {
        try (Session session = HibernateConfigForLocalDB.getSessionFactoryForLocalDB().openSession()) {
            return session.get(PracticeInfo.class, id);
        }
    }
}

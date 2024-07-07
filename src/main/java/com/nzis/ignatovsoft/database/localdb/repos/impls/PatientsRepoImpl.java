package com.nzis.ignatovsoft.database.localdb.repos.impls;

import com.nzis.ignatovsoft.configurations.application.HibernateConfigForLocalDB;
import com.nzis.ignatovsoft.database.localdb.models.PatientDbModel;
import com.nzis.ignatovsoft.database.localdb.repos.PatientRepo;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class PatientsRepoImpl implements PatientRepo {
    Session session;

    public PatientsRepoImpl() {
        session = HibernateConfigForLocalDB.getSessionFactoryForLocalDB().openSession();
    }

    @Override
    public List<PatientDbModel> getAllPatientsFromDatabase() {
        Query<PatientDbModel> query = session.createQuery("FROM PatientDbModel", PatientDbModel.class);
        List<PatientDbModel> patients = query.list();
        return patients;
    }

    @Override
    public void savePatient(PatientDbModel patientDbModel) {
        try {
            session.beginTransaction();
            session.persist(patientDbModel);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}

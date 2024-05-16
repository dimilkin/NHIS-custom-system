package com.nzis.ignatovsoft.database.repos;

import com.nzis.ignatovsoft.configurations.HibernateConfig;
import com.nzis.ignatovsoft.database.models.PatientDbModel;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class PatientsRepoImpl implements PatientRepo{
    Session session;

    public PatientsRepoImpl() {
        session = HibernateConfig.getSessionFactory().openSession();
    }

    @Override
    public List<PatientDbModel> getAllPatientsFromDatabase() {
        Query<PatientDbModel> query=  session.createQuery("FROM PatientDbModel", PatientDbModel.class);
        List<PatientDbModel> customers =query.list();

        return customers;
    }
}

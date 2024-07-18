package com.nzis.ignatovsoft.database.localdb.repos.impls;

import com.nzis.ignatovsoft.configurations.application.HibernateConfigForLocalDB;
import com.nzis.ignatovsoft.database.localdb.models.PatientDbModel;
import com.nzis.ignatovsoft.database.localdb.repos.PatientRepo;
import com.nzis.ignatovsoft.exceptions.NoEntityFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PatientsRepoImpl implements PatientRepo {

    @Override
    public List<PatientDbModel> getAllPatientsFromDatabase() {
        try (Session session = HibernateConfigForLocalDB.getSessionFactoryForLocalDB().openSession()) {
            Query<PatientDbModel> query = session.createQuery("FROM PatientDbModel", PatientDbModel.class);
            return query.list();
        }
    }

    @Override
    public boolean savePatient(PatientDbModel patientDbModel) {
        Transaction transaction = null;
        try (Session session = HibernateConfigForLocalDB.getSessionFactoryForLocalDB().openSession()) {
            transaction = session.beginTransaction();
            session.persist(patientDbModel);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();  // Log the exception
            return false;
        }
    }

    @Override
    public PatientDbModel getPatientByIdentifierValue(String patientIdentifierValue) throws NoEntityFoundException {
        try (Session session = HibernateConfigForLocalDB.getSessionFactoryForLocalDB().openSession()) {
            Query<PatientDbModel> query = session.createQuery("FROM PatientDbModel WHERE identifier = :identifier", PatientDbModel.class);
            query.setParameter("identifier", patientIdentifierValue);
            PatientDbModel patient = query.uniqueResult();
            if (patient == null) {
                throw new NoEntityFoundException("No patient with identifier: " + patientIdentifierValue + " found in the database");
            }
            return patient;
        } catch (Exception e) {
            e.printStackTrace();
            throw new NoEntityFoundException("No patient with identifier: " + patientIdentifierValue + " found in the database");
        }
    }

    @Override
    public boolean updatePatient(PatientDbModel patientDbModel) {
        Transaction transaction = null;
        try (Session session = HibernateConfigForLocalDB.getSessionFactoryForLocalDB().openSession()) {
            transaction = session.beginTransaction();
            session.merge(patientDbModel);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();  // Log the exception
            return false;
        }
    }
}
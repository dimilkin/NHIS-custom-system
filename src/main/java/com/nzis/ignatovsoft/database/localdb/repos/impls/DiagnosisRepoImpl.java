package com.nzis.ignatovsoft.database.localdb.repos.impls;

import com.nzis.ignatovsoft.configurations.application.HibernateConfigForLocalDB;
import com.nzis.ignatovsoft.database.localdb.models.DiagnosisDbModel;
import com.nzis.ignatovsoft.database.localdb.repos.DiagnosisRepo;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class DiagnosisRepoImpl implements DiagnosisRepo {

    @Override
    public boolean saveDiagnosis(DiagnosisDbModel diagnosisDbModel) {
        Transaction transaction = null;
        try (Session session = HibernateConfigForLocalDB.getSessionFactoryForLocalDB().openSession()) {
            transaction = session.beginTransaction();
            session.persist(diagnosisDbModel);
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
    public DiagnosisDbModel getDiagnosisByIdentifierValue(long diagnosisId) {
        try (Session session = HibernateConfigForLocalDB.getSessionFactoryForLocalDB().openSession()) {
            Query<DiagnosisDbModel> query = session.createQuery("FROM DiagnosisDbModel WHERE id = :diagnosisId", DiagnosisDbModel.class);
            query.setParameter("diagnosisId", diagnosisId);
            return query.uniqueResult();
        }
    }

    @Override
    public DiagnosisDbModel getDiagnosisByExamId(long examId) {
        try (Session session = HibernateConfigForLocalDB.getSessionFactoryForLocalDB().openSession()) {
            Query<DiagnosisDbModel> query = session.createQuery("FROM DiagnosisDbModel WHERE ExamDbModel .id= :examId", DiagnosisDbModel.class);
            query.setParameter("examId", examId);
            return query.uniqueResult();
        }
    }
}
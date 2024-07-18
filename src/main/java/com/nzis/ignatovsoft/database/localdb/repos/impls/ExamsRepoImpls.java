package com.nzis.ignatovsoft.database.localdb.repos.impls;

import com.nzis.ignatovsoft.configurations.application.HibernateConfigForLocalDB;
import com.nzis.ignatovsoft.database.localdb.models.ExamDbModel;
import com.nzis.ignatovsoft.database.localdb.repos.ExamsRepo;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ExamsRepoImpls implements ExamsRepo {

    @Override
    public List<ExamDbModel> getAllExamsFromDatabase() {
        try (Session session = HibernateConfigForLocalDB.getSessionFactoryForLocalDB().openSession()) {
            Query<ExamDbModel> query = session.createQuery("FROM ExamDbModel ", ExamDbModel.class);
            return query.list();
        }
    }

    @Override
    public List<ExamDbModel> getFilteredExams(LocalDate startDate, LocalDate endDate) {
        LocalDateTime startDateTime = startDate.atStartOfDay();
        LocalDateTime endDateTime = endDate.atTime(23, 59, 59);

        try (Session session = HibernateConfigForLocalDB.getSessionFactoryForLocalDB().openSession()) {
            Query<ExamDbModel> query = session.createQuery("FROM ExamDbModel WHERE closeDate BETWEEN :startDateTime AND :endDateTime", ExamDbModel.class);
            query.setParameter("startDateTime", startDateTime);
            query.setParameter("endDateTime", endDateTime);
            return query.list();
        }
    }

    @Override
    public List<ExamDbModel> getFilteredExamsByIdentifier(String identifierValue) {
        try (Session session = HibernateConfigForLocalDB.getSessionFactoryForLocalDB().openSession()) {
            Query<ExamDbModel> query = session.createQuery("FROM ExamDbModel WHERE patient.identifier = :text", ExamDbModel.class);
            query.setParameter("text", identifierValue);
            return query.list();
        }
    }

    @Override
    public void saveExam(ExamDbModel examDbModel) {
        Transaction transaction = null;
        try (Session session = HibernateConfigForLocalDB.getSessionFactoryForLocalDB().openSession()) {
            transaction = session.beginTransaction();
            session.persist(examDbModel);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();  // Log the exception
        }
    }
}
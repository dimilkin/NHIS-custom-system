package com.nzis.ignatovsoft.database.localdb.repos.impls;

import com.nzis.ignatovsoft.configurations.application.HibernateConfigForLocalDB;
import com.nzis.ignatovsoft.database.localdb.models.ExamDbModel;
import com.nzis.ignatovsoft.database.localdb.repos.ExamsRepo;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ExamsRepoImpls implements ExamsRepo {

    Session session;

    public ExamsRepoImpls() {
        session = HibernateConfigForLocalDB.getSessionFactoryForLocalDB().openSession();
    }

    @Override
    public List<ExamDbModel> getAllExamsFromDatabase() {
        Query<ExamDbModel> query =  session.createQuery("FROM ExamDbModel ", ExamDbModel.class);
        List<ExamDbModel> examDbModels = query.list();
        return examDbModels;
    }

    @Override
    public List<ExamDbModel> getFilteredExams(LocalDate startDate, LocalDate endDate) {
        LocalDateTime startDateTime = startDate.atStartOfDay();
        LocalDateTime endDateTime = endDate.atTime(23, 59, 59);

        Query<ExamDbModel> query =  session.createQuery("FROM ExamDbModel WHERE closeDate BETWEEN :startDateTime AND :endDateTime", ExamDbModel.class);
        query.setParameter("startDateTime", startDateTime);
        query.setParameter("endDateTime", endDateTime);
        List<ExamDbModel> examDbModels = query.list();
        return examDbModels;
    }

    @Override
    public List<ExamDbModel> getFilteredExamsByIdentifier(String identifierValue) {
        Query<ExamDbModel> query =  session.createQuery("FROM ExamDbModel WHERE patient.identifier = :text", ExamDbModel.class);
        query.setParameter("text", identifierValue);
        List<ExamDbModel> examDbModels = query.list();
        return examDbModels;
    }
}

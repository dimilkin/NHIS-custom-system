package com.nzis.ignatovsoft.database.localdb.repos.impls;

import com.nzis.ignatovsoft.configurations.application.HibernateConfigForLocalDB;
import com.nzis.ignatovsoft.database.localdb.models.ExamDbModel;
import com.nzis.ignatovsoft.database.localdb.repos.ExamsRepo;
import org.hibernate.Session;
import org.hibernate.query.Query;

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
}

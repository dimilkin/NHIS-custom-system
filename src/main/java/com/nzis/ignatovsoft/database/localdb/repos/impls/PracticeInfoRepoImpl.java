package com.nzis.ignatovsoft.database.localdb.repos.impls;

import com.nzis.ignatovsoft.configurations.application.HibernateConfigForLocalDB;
import com.nzis.ignatovsoft.database.localdb.models.PracticeInfo;
import com.nzis.ignatovsoft.database.localdb.repos.PracticeInfoRepo;
import org.hibernate.Session;

public class PracticeInfoRepoImpl implements PracticeInfoRepo {

    Session session;

    public PracticeInfoRepoImpl() {
        session = HibernateConfigForLocalDB.getSessionFactoryForLocalDB().openSession();
    }

    @Override
    public PracticeInfo getPracticeInfo() {
        return session.get(PracticeInfo.class, 1);
    }
}

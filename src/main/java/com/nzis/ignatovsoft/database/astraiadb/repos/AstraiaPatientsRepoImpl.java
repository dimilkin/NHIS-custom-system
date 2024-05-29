package com.nzis.ignatovsoft.database.astraiadb.repos;

import com.nzis.ignatovsoft.configurations.application.HibernateConfigForAstraia;
import com.nzis.ignatovsoft.database.astraiadb.models.AstraiaPatient;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AstraiaPatientsRepoImpl implements AstraiaPatientsRepo {
    Session astraiaSession;

    public AstraiaPatientsRepoImpl() {
        astraiaSession = HibernateConfigForAstraia.getSessionFactoryForAstraia().openSession();
    }

    @Override
    public List<AstraiaPatient> getAllPatientsFromAstraiaDatabase() {
        Query<AstraiaPatient> query=  astraiaSession.createQuery("FROM AstraiaPatient ", AstraiaPatient.class);
        List<AstraiaPatient> patients =query.list();

        return patients;
    }
}

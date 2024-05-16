package com.nzis.ignatovsoft.nhis.services;

import com.nzis.ignatovsoft.database.models.PatientDbModel;
import com.nzis.ignatovsoft.database.repos.PatientRepo;
import com.nzis.ignatovsoft.database.repos.PatientsRepoImpl;
import com.nzis.ignatovsoft.front.models.Transaction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class TestDataService {

    private final ObservableList<Transaction> allTransactions = FXCollections.observableArrayList();
    PatientRepo patientRepo;

    public TestDataService() {
        patientRepo = new PatientsRepoImpl();
        loadData();
    }

    public ObservableList<Transaction> getAllTransactions() {
        return allTransactions;
    }

    private void loadData() {

        List<PatientDbModel> allPatients = patientRepo.getAllPatientsFromDatabase();

        Transaction t1 = new Transaction(allPatients.get(0).getFirstName(), "Mili", "12.05.2023", "12:30", "0898654123", "Lorem Ipsun Dolor Sin Ameet", "Eqalas Son Teniscas Repertuare", "Sofia, Drujba II Mila Rodina 28", true);
        Transaction t2 = new Transaction(allPatients.get(0).getFirstName(), "Strumski", "02.03.2023","15:30", "084543125", "Lorem Ipsun Dolor Sin Ameet", "Eqalas Son Teniscas Repertuare", "Dupnitsa, Mila Rodina 28", false);
        Transaction t3 = new Transaction(allPatients.get(0).getFirstName(), "Grilski", "24.05.2022", "09:30", "0987135678", "Lorem Ipsun Dolor Sin Ameet", "Eqalas Son Teniscas Repertuare", "Kostenec, Skior Planinski 33", true);
        Transaction t4 = new Transaction(allPatients.get(0).getFirstName(), "Stefanov", "28.02.2021","18:00", "0898654123", "Lorem Ipsun Dolor Sin Ameet", "Eqalas Son Teniscas Repertuare", "Samokov, Drujba II Mila Rodina 28", true);
        Transaction t5 = new Transaction(allPatients.get(0).getFirstName(), "Dobrev", "17.05.2023", "14:15", "0898654123", "Lorem Ipsun Dolor Sin Ameet", "Eqalas Son Teniscas Repertuare", "Sofia, Drujba II Mila Rodina 28", true);
        Transaction t6 = new Transaction(allPatients.get(0).getFirstName(), "Koceva", "30.10.2023", "08:30","0898654123", "Lorem Ipsun Dolor Sin Ameet", "Eqalas Son Teniscas Repertuare Eqalas Son Teniscas Repertuare Eqalas Son Teniscas Repertuare", "Veliko Tyrnovo, Drujba II Mila Rodina 28", false);
        allTransactions.addAll(t1, t2,t3,t4,t5,t6);
    }
}

package com.nzis.ignatovsoft.services;

import com.nzis.ignatovsoft.front.models.Transaction;
import com.nzis.ignatovsoft.models.entities.AddressBase;
import com.nzis.ignatovsoft.models.entities.HumanNameBase;
import com.nzis.ignatovsoft.models.entities.Patient;
import com.nzis.ignatovsoft.models.nhis.Header;
import com.nzis.ignatovsoft.models.nhis.StartExaminationRequest;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TestDataService {

    private final ObservableList<Transaction> allTransactions = FXCollections.observableArrayList();

    public TestDataService() {
        loadData();
    }

    public ObservableList<Transaction> getAllTransactions() {
        return allTransactions;
    }

    private void loadData() {
        Transaction t1 = new Transaction("Dimi", "Mili", "12.05.2023", "12:30", "0898654123", "Lorem Ipsun Dolor Sin Ameet", "Eqalas Son Teniscas Repertuare", "Sofia, Drujba II Mila Rodina 28", true);
        Transaction t2 = new Transaction("Bobi", "Strumski", "02.03.2023","15:30", "084543125", "Lorem Ipsun Dolor Sin Ameet", "Eqalas Son Teniscas Repertuare", "Dupnitsa, Mila Rodina 28", false);
        Transaction t3 = new Transaction("Yavor", "Grilski", "24.05.2022", "09:30", "0987135678", "Lorem Ipsun Dolor Sin Ameet", "Eqalas Son Teniscas Repertuare", "Kostenec, Skior Planinski 33", true);
        Transaction t4 = new Transaction("Kiro", "Stefanov", "28.02.2021","18:00", "0898654123", "Lorem Ipsun Dolor Sin Ameet", "Eqalas Son Teniscas Repertuare", "Samokov, Drujba II Mila Rodina 28", true);
        Transaction t5 = new Transaction("Emil", "Dobrev", "17.05.2023", "14:15", "0898654123", "Lorem Ipsun Dolor Sin Ameet", "Eqalas Son Teniscas Repertuare", "Sofia, Drujba II Mila Rodina 28", true);
        Transaction t6 = new Transaction("Marina", "Koceva", "30.10.2023", "08:30","0898654123", "Lorem Ipsun Dolor Sin Ameet", "Eqalas Son Teniscas Repertuare Eqalas Son Teniscas Repertuare Eqalas Son Teniscas Repertuare", "Veliko Tyrnovo, Drujba II Mila Rodina 28", false);
        allTransactions.addAll(t1, t2,t3,t4,t5,t6);
    }

    private StartExaminationRequest generateDummyRequest() {
        Header header = new Header("0", "1234", "Kole", "0", "Poluchi", "Li be", "string", "2023-12-18" );
        StartExaminationRequest.Examination examination = new StartExaminationRequest.Examination("pak az", "2222-12-12", "0", "chastno", "Koleto");
        HumanNameBase name = new HumanNameBase("Koleto", "Poluchi", "Bonus");
        AddressBase addressBase = new AddressBase("BGN", "Samokov", "ul Riska 44");
        Patient patient = new Patient("0", "baceto", "0028", "1991-03-03", "sisgender", name, addressBase, "BGN", "0887655", "alalaba@test.com");
        StartExaminationRequest.Performer performer = new StartExaminationRequest.Performer("12345", "zybar", "bab mu", "008888", "Main");

        StartExaminationRequest.Contents contents = new StartExaminationRequest.Contents(examination, patient, performer);

        return new StartExaminationRequest(header, contents);
    }
}

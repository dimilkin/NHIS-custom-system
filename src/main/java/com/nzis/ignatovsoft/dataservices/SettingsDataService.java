package com.nzis.ignatovsoft.dataservices;

import com.nzis.ignatovsoft.database.localdb.models.PracticeInfo;
import com.nzis.ignatovsoft.database.localdb.repos.SettingsRepo;
import com.nzis.ignatovsoft.database.localdb.repos.impls.SettingsRepoImpl;

public class SettingsDataService {

    public SettingsRepo settingsRepo;
    private PracticeInfo practiceInfo;

    public SettingsDataService() {
        this.settingsRepo = new SettingsRepoImpl();
    }

    public PracticeInfo getSettings() {
        return settingsRepo.getSettingsById(1);
    }

    public boolean updateSettings(String practiceName, String doctorsId, String doctorsQualification, String tokenPin) {
        PracticeInfo practiceInfo = settingsRepo.getSettingsById(1);
        if (practiceInfo != null) {
            practiceInfo.setPracticeName(practiceName);
            practiceInfo.setDoctorId(doctorsId);
            practiceInfo.setDoctorsQualification(doctorsQualification);
            practiceInfo.setSignerPin(tokenPin);
            return settingsRepo.saveSettings(practiceInfo);
        }
        practiceInfo = generatePracticeInfo(practiceName, doctorsId, doctorsQualification, tokenPin);
        return settingsRepo.saveSettings(practiceInfo);
    }

    private PracticeInfo generatePracticeInfo(String practiceName, String doctorsId, String doctorsQualification, String tokenPin) {
        PracticeInfo practiceInfo = new PracticeInfo();
        practiceInfo.setPracticeName(practiceName);
        practiceInfo.setDoctorId(doctorsId);
        practiceInfo.setDoctorsQualification(doctorsQualification);
        practiceInfo.setSignerPin(tokenPin);
        return practiceInfo;
    }
}

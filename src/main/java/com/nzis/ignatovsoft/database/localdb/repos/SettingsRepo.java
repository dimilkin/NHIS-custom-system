package com.nzis.ignatovsoft.database.localdb.repos;

import com.nzis.ignatovsoft.database.localdb.models.PracticeInfo;

public interface SettingsRepo {

    boolean saveSettings(PracticeInfo practiceInfo);

    PracticeInfo getSettings();

    PracticeInfo getSettingsById(long id);
}

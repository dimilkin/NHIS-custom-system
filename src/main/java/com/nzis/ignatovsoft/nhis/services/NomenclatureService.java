package com.nzis.ignatovsoft.nhis.services;

import com.nzis.ignatovsoft.nhis.models.nhis.nomenclatures.c002.Entry;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static com.nzis.ignatovsoft.NomeConstants.ICD_CODES;


public class NomenclatureService {

    private static NomenclatureService instance;
    private NetworkService networkService;
    private Map<String, List<Entry>> nomenclaturesCache;
    private final ScheduledExecutorService scheduler;

    private NomenclatureService() {
        this.networkService = new NetworkServiceImpl();
        this.nomenclaturesCache = new HashMap<>();
        this.scheduler = Executors.newScheduledThreadPool(1);
        this.scheduler.scheduleAtFixedRate(this::clearCache, 1, 1, TimeUnit.DAYS);
    }

    public static NomenclatureService getInstance() {
        if (instance == null) {
            instance = new NomenclatureService();
        }
        return instance;
    }

    public ObservableList<Entry> getObservableNomenclatures(String code) {
        return FXCollections.observableArrayList(getNomenclaturesForCode(code));
    }

    public List<Entry> getNomenclaturesForCode(String code) {
        if (nomenclaturesCache.containsKey(code)) {
            return nomenclaturesCache.get(code);
        }
        List<Entry> nomenclatures = networkService.getNomenclaturesC002(code).join();
        nomenclaturesCache.put(code, nomenclatures);
        return nomenclatures;
    }

    public Entry getCorrectValue(String keyValue, String code) {
        for (Entry entry : getNomenclaturesForCode(code)) {
            if (entry.getKey().getValue().equals(keyValue)) {
                return entry;
            }
        }
        return null;
    }

    private void clearCache() {
        nomenclaturesCache.clear();
        getNomenclaturesForCode(ICD_CODES);
    }

}

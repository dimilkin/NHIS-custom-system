package com.nzis.ignatovsoft.nhis.services;

import com.nzis.ignatovsoft.nhis.models.nhis.nomenclatures.c002.Entry;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Collections;
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

    public ObservableList<Entry> getObservableNomenclatures(String nomeclatureClCode) {
        return FXCollections.observableArrayList(getNomenclaturesForCode(nomeclatureClCode));
    }

    public List<Entry> getNomenclaturesForCode(String nomeclatureClCode) {
        if (nomenclaturesCache.containsKey(nomeclatureClCode)) {
            return nomenclaturesCache.get(nomeclatureClCode);
        }
        List<Entry> nomenclatures = networkService.getNomenclaturesC002(nomeclatureClCode)
                .exceptionally(ex -> {
                    ex.printStackTrace();
                    return Collections.emptyList();
                })
                .join();
        nomenclaturesCache.put(nomeclatureClCode, nomenclatures);
        return nomenclatures;
    }

    public Entry getCorrectValue(String termKey, String nomeclatureClCode) {
        for (Entry entry : getNomenclaturesForCode(nomeclatureClCode)) {
            if (entry.getKey().getValue().equals(termKey)) {
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

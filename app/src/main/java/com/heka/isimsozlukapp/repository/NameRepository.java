package com.heka.isimsozlukapp.repository;

import com.heka.isimsozlukapp.model.Name;
import com.heka.isimsozlukapp.service.NameAPI;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class NameRepository {

    private NameAPI nameAPI;

    public NameRepository(NameAPI nameAPI) {
        this.nameAPI = nameAPI;
    }

    public Observable<List<Name>> searchNames(String query, String apiKey) {
        return nameAPI.lookupName(query, apiKey);
    }


}

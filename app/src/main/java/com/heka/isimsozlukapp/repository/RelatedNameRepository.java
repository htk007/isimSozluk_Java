package com.heka.isimsozlukapp.repository;

import com.heka.isimsozlukapp.model.Names;
import com.heka.isimsozlukapp.service.NameAPI;

import io.reactivex.rxjava3.core.Observable;

public class RelatedNameRepository {
    private NameAPI nameAPI;

    public RelatedNameRepository(NameAPI nameAPI){ this.nameAPI = nameAPI; }

    public Observable<Names> getUsingNames(String name, String usage, String apiKey){
        return nameAPI.getRelatedNames(name,usage,apiKey);
    }

}

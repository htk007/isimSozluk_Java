package com.heka.isimsozlukapp.service;

import static com.heka.isimsozlukapp.util.Constants.LOOKUP_JSON_NAME;
import static com.heka.isimsozlukapp.util.Constants.QUERY_KEY_KEY;
import static com.heka.isimsozlukapp.util.Constants.QUERY_KEY_NAME;
import static com.heka.isimsozlukapp.util.Constants.QUERY_KEY_USAGE;
import static com.heka.isimsozlukapp.util.Constants.RELATED_JSON_NAME;

import com.heka.isimsozlukapp.model.Name;
import com.heka.isimsozlukapp.model.Names;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NameAPI {
    @GET(LOOKUP_JSON_NAME)
    Observable<List<Name>> lookupName(@Query(QUERY_KEY_NAME) String name, @Query(QUERY_KEY_KEY) String key);
    @GET(RELATED_JSON_NAME)
    Observable<Names> getRelatedNames(@Query(QUERY_KEY_NAME) String name, @Query(QUERY_KEY_USAGE) String usage, @Query(QUERY_KEY_KEY) String key);

}

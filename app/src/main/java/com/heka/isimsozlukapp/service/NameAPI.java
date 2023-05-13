package com.heka.isimsozlukapp.service;

import static com.heka.isimsozlukapp.util.Constants.LOOKUP_JSON_NAME;
import static com.heka.isimsozlukapp.util.Constants.QUERY_KEY_KEY;
import static com.heka.isimsozlukapp.util.Constants.QUERY_KEY_NAME;

import com.heka.isimsozlukapp.model.Name;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NameAPI {
    @GET(LOOKUP_JSON_NAME)
    Observable<List<Name>> lookupName(@Query(QUERY_KEY_NAME) String name, @Query(QUERY_KEY_KEY) String key);
    //Call<List<Name>> lookupName(@Query(QUERY_KEY_NAME) String name, @Query(QUERY_KEY_KEY) String key);
}

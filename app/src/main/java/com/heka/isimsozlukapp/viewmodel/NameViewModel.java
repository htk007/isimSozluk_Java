package com.heka.isimsozlukapp.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.heka.isimsozlukapp.ApiClient;
import com.heka.isimsozlukapp.model.Name;
import com.heka.isimsozlukapp.model.Usage;
import com.heka.isimsozlukapp.repository.NameRepository;
import com.heka.isimsozlukapp.service.NameAPI;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class NameViewModel extends ViewModel {
    private NameRepository nameRepository;
    private MutableLiveData<List<Name>> nameList;

    public NameViewModel() {
        nameList = new MutableLiveData<>();
        nameRepository = new NameRepository(ApiClient.getRetrofitClient().create(NameAPI.class));
    }

    public LiveData<List<Name>> getNameList() {
        return nameList;
    }

    public void searchNames(String query, String apiKey) {
        Log.i("HKLOG","Query is: "+query);
        nameRepository.searchNames(query, apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Name>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(List<Name> names) {
                        for(Name name: names){
                            Log.i("HKLOG","usages size:" +name.getUsages().size());
                            for(Usage usage: name.getUsages()){
                                Log.i("HKLOG","USAGE IS: "+usage.getUsageFull());
                            }
                        }
                        nameList.setValue(names);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("NameViewModel", "onError: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }
}

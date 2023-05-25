package com.heka.isimsozlukapp.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.heka.isimsozlukapp.model.Names;
import com.heka.isimsozlukapp.repository.RelatedNameRepository;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class RelatedNamesViewModel extends ViewModel {
private RelatedNameRepository relatedNameRepository;
MutableLiveData<Names> relatedNamesList;

public RelatedNamesViewModel(){
    relatedNamesList = new MutableLiveData<>();
}

public LiveData<Names> getRelatedNames(){ return relatedNamesList;}

    public void getRelatedNames(String name, String usage, String apiKey){
        Log.i("HKLOG","name is: "+name +" usage: "+ usage);
        relatedNameRepository.getUsingNames(name, usage, apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Names>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Names names) {
                        relatedNamesList.setValue(names);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}

package com.heka.isimsozlukapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.heka.isimsozlukapp.model.Names;
import com.heka.isimsozlukapp.repository.RelatedNameRepository;

public class RelatedNamesViewModel extends ViewModel {
private RelatedNameRepository relatedNameRepository;
MutableLiveData<Names> relatedNamesList;

public RelatedNamesViewModel(){
    relatedNamesList = new MutableLiveData<>();
}

public LiveData<Names> getRelatedNames(){ return relatedNamesList;}


}

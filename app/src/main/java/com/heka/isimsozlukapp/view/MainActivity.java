package com.heka.isimsozlukapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.heka.isimsozlukapp.R;
import com.heka.isimsozlukapp.model.Name;
import com.heka.isimsozlukapp.model.SecretStorage;
import com.heka.isimsozlukapp.model.Usage;
import com.heka.isimsozlukapp.service.NameAPI;
import com.heka.isimsozlukapp.util.Constants;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.internal.schedulers.RxThreadFactory;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ArrayList<Name> nameArrayList;
    Retrofit retrofit;
    String name ="Hasan";
    Button buttonSearch;
    EditText editTextName;
    CompositeDisposable compositeDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Gson gson = new GsonBuilder().setLenient().create();

        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();

        initView();
        manageOnClickEvents();

    }

    private void initView(){
        buttonSearch = findViewById(R.id.search_button);
        editTextName = findViewById(R.id.search_edittext);
    }

    private void manageOnClickEvents(){
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputName = editTextName.getText().toString();
                if(inputValidation(inputName)){
                    setLookupName(inputName);
                }
            }
        });
    }

    private boolean inputValidation(String input){
        if(input.isEmpty()){
            return false;
        }
        return true;
    }

    private void setLookupName(String nameValue){
        NameAPI nameAPI = retrofit.create(NameAPI.class);

        compositeDisposable = new CompositeDisposable();

        compositeDisposable.add(nameAPI.lookupName(nameValue,SecretStorage.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse));
    }

    private void handleResponse(List<Name> nameList){
        nameArrayList = new ArrayList<>(nameList);

        for(Name name :nameArrayList){
            Log.i("HKLOG", "gender: "+ name.getGender()+ " "+name.getUsages().size());
            for(Usage nameUsage: name.getUsages()){
                Log.i("HKLOG","usage: " +nameUsage.getUsageFull().toString());
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }
}
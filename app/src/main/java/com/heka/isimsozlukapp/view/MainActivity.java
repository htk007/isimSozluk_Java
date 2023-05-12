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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ArrayList<Name> nameArrayList;
    Retrofit retrofit;
    String name ="Hasan";
    Button buttonSearch;
    EditText editTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Gson gson = new GsonBuilder().setLenient().create();

        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
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

        Call<List<Name>> call = nameAPI.lookupName(nameValue, SecretStorage.API_KEY);

        call.enqueue(new Callback<List<Name>>() {
            @Override
            public void onResponse(Call<List<Name>> call, Response<List<Name>> response) {
                if(response.isSuccessful()){
                   List<Name> nameList=  response.body();
                    nameArrayList = new ArrayList<>(nameList);

                    for(Name name :nameArrayList){
                        Log.i("HKLOG", "gender: "+ name.getGender()+ " "+name.getUsages().size());
                        for(Usage nameUsage: name.getUsages()){
                            Log.i("HKLOG","usage: " +nameUsage.getUsageFull().toString());
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Name>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
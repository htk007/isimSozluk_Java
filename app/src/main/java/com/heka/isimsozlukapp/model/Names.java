package com.heka.isimsozlukapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Names {
    @SerializedName("names")
    private List<String> names;

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }
}

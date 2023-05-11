package com.heka.isimsozlukapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Usage {
    @SerializedName("usage_code")
    @Expose
    private String usageCode;
    @SerializedName("usage_full")
    @Expose
    private String usageFull;
    @SerializedName("usage_gender")
    @Expose
    private String usageGender;

    public Usage(String usageCode, String usageFull, String usageGender) {
        this.usageCode = usageCode;
        this.usageFull = usageFull;
        this.usageGender = usageGender;
    }

    public String getUsageCode() {
        return usageCode;
    }

    public void setUsageCode(String usageCode) {
        this.usageCode = usageCode;
    }

    public String getUsageFull() {
        return usageFull;
    }

    public void setUsageFull(String usageFull) {
        this.usageFull = usageFull;
    }

    public String getUsageGender() {
        return usageGender;
    }

    public void setUsageGender(String usageGender) {
        this.usageGender = usageGender;
    }

}

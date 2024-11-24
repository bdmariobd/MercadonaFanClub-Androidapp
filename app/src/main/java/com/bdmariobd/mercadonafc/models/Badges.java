package com.bdmariobd.mercadonafc.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class Badges {
    @SerializedName("is_water")
    @Expose
    private Boolean isWater;
    @SerializedName("requires_age_check")
    @Expose
    private Boolean requiresAgeCheck;

    @Override
    public String toString() {
        return "Badges{" +
                "isWater=" + isWater +
                ", requiresAgeCheck=" + requiresAgeCheck +
                '}';
    }

    public Boolean getIsWater() {
        return isWater;
    }

    public void setIsWater(Boolean isWater) {
        this.isWater = isWater;
    }

    public Boolean getRequiresAgeCheck() {
        return requiresAgeCheck;
    }

    public void setRequiresAgeCheck(Boolean requiresAgeCheck) {
        this.requiresAgeCheck = requiresAgeCheck;
    }

}

package com.bdmariobd.mercadonafc.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class Details {

    @SerializedName("brand")
    @Expose
    private String brand;
    @SerializedName("origin")
    @Expose
    private String origin;
    @SerializedName("suppliers")
    @Expose
    private List<Object> suppliers;
    @SerializedName("legal_name")
    @Expose
    private String legalName;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("counter_info")
    @Expose
    private Object counterInfo;
    @SerializedName("danger_mentions")
    @Expose
    private String dangerMentions;
    @SerializedName("alcohol_by_volume")
    @Expose
    private String alcoholByVolume;
    @SerializedName("mandatory_mentions")
    @Expose
    private String mandatoryMentions;
    @SerializedName("production_variant")
    @Expose
    private String productionVariant;
    @SerializedName("usage_instructions")
    @Expose
    private String usageInstructions;
    @SerializedName("storage_instructions")
    @Expose
    private String storageInstructions;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public List<Object> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<Object> suppliers) {
        this.suppliers = suppliers;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getCounterInfo() {
        return counterInfo;
    }

    public void setCounterInfo(Object counterInfo) {
        this.counterInfo = counterInfo;
    }

    public String getDangerMentions() {
        return dangerMentions;
    }

    public void setDangerMentions(String dangerMentions) {
        this.dangerMentions = dangerMentions;
    }

    public String getAlcoholByVolume() {
        return alcoholByVolume;
    }

    public void setAlcoholByVolume(String alcoholByVolume) {
        this.alcoholByVolume = alcoholByVolume;
    }

    public String getMandatoryMentions() {
        return mandatoryMentions;
    }

    public void setMandatoryMentions(String mandatoryMentions) {
        this.mandatoryMentions = mandatoryMentions;
    }

    public String getProductionVariant() {
        return productionVariant;
    }

    public void setProductionVariant(String productionVariant) {
        this.productionVariant = productionVariant;
    }

    public String getUsageInstructions() {
        return usageInstructions;
    }

    public void setUsageInstructions(String usageInstructions) {
        this.usageInstructions = usageInstructions;
    }

    public String getStorageInstructions() {
        return storageInstructions;
    }

    public void setStorageInstructions(String storageInstructions) {
        this.storageInstructions = storageInstructions;
    }

}

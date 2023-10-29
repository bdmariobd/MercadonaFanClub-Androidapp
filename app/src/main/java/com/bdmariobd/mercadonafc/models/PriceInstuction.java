package com.bdmariobd.mercadonafc.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class PriceInstuction {

    @SerializedName("iva")
    @Expose
    private Integer iva;
    @SerializedName("is_new")
    @Expose
    private Boolean isNew;
    @SerializedName("is_pack")
    @Expose
    private Boolean isPack;
    @SerializedName("pack_size")
    @Expose
    private Object packSize;
    @SerializedName("unit_name")
    @Expose
    private String unitName;
    @SerializedName("unit_size")
    @Expose
    private Double unitSize;
    @SerializedName("bulk_price")
    @Expose
    private String bulkPrice;
    @SerializedName("unit_price")
    @Expose
    private String unitPrice;
    @SerializedName("approx_size")
    @Expose
    private Boolean approxSize;
    @SerializedName("size_format")
    @Expose
    private String sizeFormat;
    @SerializedName("total_units")
    @Expose
    private Integer totalUnits;
    @SerializedName("unit_selector")
    @Expose
    private Boolean unitSelector;
    @SerializedName("bunch_selector")
    @Expose
    private Boolean bunchSelector;
    @SerializedName("drained_weight")
    @Expose
    private Object drainedWeight;
    @SerializedName("selling_method")
    @Expose
    private Integer sellingMethod;
    @SerializedName("price_decreased")
    @Expose
    private Boolean priceDecreased;
    @SerializedName("reference_price")
    @Expose
    private String referencePrice;
    @SerializedName("min_bunch_amount")
    @Expose
    private Double minBunchAmount;
    @SerializedName("reference_format")
    @Expose
    private String referenceFormat;
    @SerializedName("previous_unit_price")
    @Expose
    private String previousUnitPrice;
    @SerializedName("increment_bunch_amount")
    @Expose
    private Double incrementBunchAmount;

    public Integer getIva() {
        return iva;
    }

    public void setIva(Integer iva) {
        this.iva = iva;
    }

    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }

    public Boolean getIsPack() {
        return isPack;
    }

    public void setIsPack(Boolean isPack) {
        this.isPack = isPack;
    }

    public Object getPackSize() {
        return packSize;
    }

    public void setPackSize(Object packSize) {
        this.packSize = packSize;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Double getUnitSize() {
        return unitSize;
    }

    public void setUnitSize(Double unitSize) {
        this.unitSize = unitSize;
    }

    public String getBulkPrice() {
        return bulkPrice;
    }

    public void setBulkPrice(String bulkPrice) {
        this.bulkPrice = bulkPrice;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Boolean getApproxSize() {
        return approxSize;
    }

    public void setApproxSize(Boolean approxSize) {
        this.approxSize = approxSize;
    }

    public String getSizeFormat() {
        return sizeFormat;
    }

    public void setSizeFormat(String sizeFormat) {
        this.sizeFormat = sizeFormat;
    }

    public Integer getTotalUnits() {
        return totalUnits;
    }

    public void setTotalUnits(Integer totalUnits) {
        this.totalUnits = totalUnits;
    }

    public Boolean getUnitSelector() {
        return unitSelector;
    }

    public void setUnitSelector(Boolean unitSelector) {
        this.unitSelector = unitSelector;
    }

    public Boolean getBunchSelector() {
        return bunchSelector;
    }

    public void setBunchSelector(Boolean bunchSelector) {
        this.bunchSelector = bunchSelector;
    }

    public Object getDrainedWeight() {
        return drainedWeight;
    }

    public void setDrainedWeight(Object drainedWeight) {
        this.drainedWeight = drainedWeight;
    }

    public Integer getSellingMethod() {
        return sellingMethod;
    }

    public void setSellingMethod(Integer sellingMethod) {
        this.sellingMethod = sellingMethod;
    }

    public Boolean getPriceDecreased() {
        return priceDecreased;
    }

    public void setPriceDecreased(Boolean priceDecreased) {
        this.priceDecreased = priceDecreased;
    }

    public String getReferencePrice() {
        return referencePrice;
    }

    public void setReferencePrice(String referencePrice) {
        this.referencePrice = referencePrice;
    }

    public Double getMinBunchAmount() {
        return minBunchAmount;
    }

    public void setMinBunchAmount(Double minBunchAmount) {
        this.minBunchAmount = minBunchAmount;
    }

    public String getReferenceFormat() {
        return referenceFormat;
    }

    public void setReferenceFormat(String referenceFormat) {
        this.referenceFormat = referenceFormat;
    }

    public String getPreviousUnitPrice() {
        return previousUnitPrice;
    }

    public void setPreviousUnitPrice(String previousUnitPrice) {
        this.previousUnitPrice = previousUnitPrice;
    }

    public Double getIncrementBunchAmount() {
        return incrementBunchAmount;
    }

    public void setIncrementBunchAmount(Double incrementBunchAmount) {
        this.incrementBunchAmount = incrementBunchAmount;
    }
}
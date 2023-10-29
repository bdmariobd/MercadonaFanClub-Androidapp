package com.bdmariobd.mercadonafc.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.processing.Generated;


@Generated("jsonschema2pojo")
public class PriceDrops {

    @SerializedName("layout")
    @Expose
    private String layout;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("source_code")
    @Expose
    private String sourceCode;
    @SerializedName("items")
    @Expose
    private List<Product> products;

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setItems(List<Product> products) {
        this.products = products;
    }

}
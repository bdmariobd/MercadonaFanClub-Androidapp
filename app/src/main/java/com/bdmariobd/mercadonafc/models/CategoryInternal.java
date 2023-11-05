package com.bdmariobd.mercadonafc.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class CategoryInternal {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("order")
    @Expose
    private Integer order;
    @SerializedName("layout")
    @Expose
    private Integer layout;
    @SerializedName("products")
    @Expose
    private List<Product> products;
    @SerializedName("published")
    @Expose
    private Boolean published;
    @SerializedName("is_extended")
    @Expose
    private Boolean isExtended;

    @Override
    public String toString() {
        return "CategoryInternal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", order=" + order +
                ", layout=" + layout +
                ", products=" + products +
                ", published=" + published +
                ", isExtended=" + isExtended +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getLayout() {
        return layout;
    }

    public void setLayout(Integer layout) {
        this.layout = layout;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public Boolean getIsExtended() {
        return isExtended;
    }

    public void setIsExtended(Boolean isExtended) {
        this.isExtended = isExtended;
    }

}

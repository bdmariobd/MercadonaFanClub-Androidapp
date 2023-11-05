package com.bdmariobd.mercadonafc.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class CategoryProducts {
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
    @SerializedName("published")
    @Expose
    private Boolean published;
    @SerializedName("categories")
    @Expose
    private List<CategoryInternal> categories;
    @SerializedName("is_extended")
    @Expose
    private Boolean isExtended;

    @Override
    public String toString() {
        return "CategoryProducts{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", order=" + order +
                ", layout=" + layout +
                ", published=" + published +
                ", categories=" + categories +
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

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public List<CategoryInternal> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryInternal> categories) {
        this.categories = categories;
    }

    public Boolean getIsExtended() {
        return isExtended;
    }

    public void setIsExtended(Boolean isExtended) {
        this.isExtended = isExtended;
    }

}

/*
@Generated("jsonschema2pojo")
class Product {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("limit")
    @Expose
    private Integer limit;
    @SerializedName("badges")
    @Expose
    private Badges badges;
    @SerializedName("packaging")
    @Expose
    private String packaging;
    @SerializedName("published")
    @Expose
    private Boolean published;
    @SerializedName("share_url")
    @Expose
    private String shareUrl;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("categories")
    @Expose
    private List<Category__1> categories;
    @SerializedName("display_name")
    @Expose
    private String displayName;
    @SerializedName("unavailable_from")
    @Expose
    private Object unavailableFrom;
    @SerializedName("price_instructions")
    @Expose
    private PriceInstructions priceInstructions;
    @SerializedName("unavailable_weekdays")
    @Expose
    private List<Object> unavailableWeekdays;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Badges getBadges() {
        return badges;
    }

    public void setBadges(Badges badges) {
        this.badges = badges;
    }

    public String getPackaging() {
        return packaging;
    }

    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public List<Category__1> getCategories() {
        return categories;
    }

    public void setCategories(List<Category__1> categories) {
        this.categories = categories;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Object getUnavailableFrom() {
        return unavailableFrom;
    }

    public void setUnavailableFrom(Object unavailableFrom) {
        this.unavailableFrom = unavailableFrom;
    }

    public PriceInstructions getPriceInstructions() {
        return priceInstructions;
    }

    public void setPriceInstructions(PriceInstructions priceInstructions) {
        this.priceInstructions = priceInstructions;
    }

    public List<Object> getUnavailableWeekdays() {
        return unavailableWeekdays;
    }

    public void setUnavailableWeekdays(List<Object> unavailableWeekdays) {
        this.unavailableWeekdays = unavailableWeekdays;
    }

}
 */
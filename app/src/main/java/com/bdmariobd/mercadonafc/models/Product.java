package com.bdmariobd.mercadonafc.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
class Badges {
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

@Generated("jsonschema2pojo")
class Category {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("level")
    @Expose
    private Integer level;
    @SerializedName("order")
    @Expose
    private Integer order;
    @SerializedName("categories")
    @Expose
    private List<Category__1> categories;

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", order=" + order +
                ", categories=" + categories +
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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public List<Category__1> getCategories() {
        return categories;
    }

    public void setCategories(List<Category__1> categories) {
        this.categories = categories;
    }

}

@Generated("jsonschema2pojo")
class Category__1 {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("level")
    @Expose
    private Integer level;
    @SerializedName("order")
    @Expose
    private Integer order;
    @SerializedName("categories")
    @Expose
    private List<Category__2> categories;

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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public List<Category__2> getCategories() {
        return categories;
    }

    public void setCategories(List<Category__2> categories) {
        this.categories = categories;
    }

}

@Generated("jsonschema2pojo")
class Category__2 {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("level")
    @Expose
    private Integer level;
    @SerializedName("order")
    @Expose
    private Integer order;

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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

}

@Generated("jsonschema2pojo")
class Details {

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

@Generated("jsonschema2pojo")
public class Product {


    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("ean")
    @Expose
    private String ean;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("brand")
    @Expose
    private String brand;
    @SerializedName("limit")
    @Expose
    private Integer limit;
    @SerializedName("badges")
    @Expose
    private Badges badges;
    @SerializedName("origin")
    @Expose
    private String origin;
    @SerializedName("photos")
    @Expose
    private List<Photo> photos;
    @SerializedName("details")
    @Expose
    private Details details;
    @SerializedName("is_bulk")
    @Expose
    private Boolean isBulk;
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
    private List<Category> categories;
    @SerializedName("extra_info")
    @Expose
    private List<Object> extraInfo;
    @SerializedName("display_name")
    @Expose
    private String displayName;
    @SerializedName("unavailable_from")
    @Expose
    private Object unavailableFrom;
    @SerializedName("is_variable_weight")
    @Expose
    private Boolean isVariableWeight;
    @SerializedName("price_instructions")
    @Expose
    private PriceInstructions priceInstructions;
    @SerializedName("unavailable_weekdays")
    @Expose
    private List<Object> unavailableWeekdays;
    @SerializedName("nutrition_information")
    @Expose
    private NutritionInformation nutritionInformation;

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", ean='" + ean + '\'' +
                ", slug='" + slug + '\'' +
                ", brand='" + brand + '\'' +
                ", limit=" + limit +
                ", badges=" + badges +
                ", origin='" + origin + '\'' +
                ", photos=" + photos +
                ", details=" + details +
                ", isBulk=" + isBulk +
                ", packaging='" + packaging + '\'' +
                ", published=" + published +
                ", shareUrl='" + shareUrl + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", categories=" + categories +
                ", extraInfo=" + extraInfo +
                ", displayName='" + displayName + '\'' +
                ", unavailableFrom=" + unavailableFrom +
                ", isVariableWeight=" + isVariableWeight +
                ", priceInstructions=" + priceInstructions +
                ", unavailableWeekdays=" + unavailableWeekdays +
                ", nutritionInformation=" + nutritionInformation +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    public Boolean getIsBulk() {
        return isBulk;
    }

    public void setIsBulk(Boolean isBulk) {
        this.isBulk = isBulk;
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

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Object> getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(List<Object> extraInfo) {
        this.extraInfo = extraInfo;
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

    public Boolean getIsVariableWeight() {
        return isVariableWeight;
    }

    public void setIsVariableWeight(Boolean isVariableWeight) {
        this.isVariableWeight = isVariableWeight;
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

    public NutritionInformation getNutritionInformation() {
        return nutritionInformation;
    }

    public void setNutritionInformation(NutritionInformation nutritionInformation) {
        this.nutritionInformation = nutritionInformation;
    }

}

@Generated("jsonschema2pojo")
class NutritionInformation {

    @SerializedName("allergens")
    @Expose
    private String allergens;
    @SerializedName("ingredients")
    @Expose
    private String ingredients;

    public String getAllergens() {
        return allergens;
    }

    public void setAllergens(String allergens) {
        this.allergens = allergens;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

}

@Generated("jsonschema2pojo")
class Photo {

    @SerializedName("zoom")
    @Expose
    private String zoom;
    @SerializedName("regular")
    @Expose
    private String regular;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("perspective")
    @Expose
    private Integer perspective;

    public String getZoom() {
        return zoom;
    }

    public void setZoom(String zoom) {
        this.zoom = zoom;
    }

    public String getRegular() {
        return regular;
    }

    public void setRegular(String regular) {
        this.regular = regular;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Integer getPerspective() {
        return perspective;
    }

    public void setPerspective(Integer perspective) {
        this.perspective = perspective;
    }

}




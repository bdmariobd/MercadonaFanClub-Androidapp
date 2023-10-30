package com.bdmariobd.mercadonafc.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class Photo {

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

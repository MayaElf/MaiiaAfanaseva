package ru.training.at.hw10.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class TrelloBoardModel {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("descData")
    @Expose
    private String descData = null;
    @SerializedName("closed")
    @Expose
    private boolean closed;
    @SerializedName("idOrganization")
    @Expose
    private String idOrganization;
    @SerializedName("idEnterprise")
    @Expose
    private String idEnterprise = null;
    @SerializedName("pinned")
    @Expose
    private boolean pinned;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("shortUrl")
    @Expose
    private String shortUrl;

}

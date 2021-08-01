package ru.training.at.hw10.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class TrelloCardModel {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("closed")
    @Expose
    public boolean closed;
    @SerializedName("desc")
    @Expose
    public String desc;
    @SerializedName("idBoard")
    @Expose
    public String idBoard;
    @SerializedName("idList")
    @Expose
    public String idList;
    @SerializedName("idShort")
    @Expose
    public int idShort;
    @SerializedName("manualCoverAttachment")
    @Expose
    public boolean manualCoverAttachment;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("pos")
    @Expose
    public int pos;
    @SerializedName("shortLink")
    @Expose
    public String shortLink;
    @SerializedName("isTemplate")
    @Expose
    public boolean isTemplate;
    @SerializedName("dueComplete")
    @Expose
    public boolean dueComplete;
    @SerializedName("shortUrl")
    @Expose
    public String shortUrl;
    @SerializedName("url")
    @Expose
    public String url;


    public boolean getIsClosed() {
        return closed;
    }

    public boolean getIsTemplate() {
        return isTemplate;
    }

    public boolean getManualAttachment() {
        return manualCoverAttachment;
    }

}

package ru.training.at.hw10.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class TrelloListModel {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("closed")
    @Expose
    private boolean closed;
    @SerializedName("pos")
    @Expose
    private float pos;
    @SerializedName("idBoard")
    @Expose
    private String idBoard;
}

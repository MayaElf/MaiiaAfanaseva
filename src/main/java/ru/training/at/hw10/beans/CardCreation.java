package ru.training.at.hw10.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class CardCreation {
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("idList")
    @Expose
    public String idList;
}

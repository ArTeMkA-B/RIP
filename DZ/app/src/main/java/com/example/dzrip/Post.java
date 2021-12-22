package com.example.dzrip;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {
    @SerializedName("id_language")
    @Expose
    private int id_language;
    @SerializedName("language_name")
    @Expose
    private String language_name;
    @SerializedName("descript")
    @Expose
    private String descript;
    @SerializedName("creation_year")
    @Expose
    private int creation_year;

    public Post(String name, String descript, int year)
    {
        this.language_name = name;
        this.descript = descript;
        this.creation_year = year;
    }

    public int getId_language() {
        return id_language;
    }

    public String getLanguage_name() {
        return language_name;
    }

    public String getDescript() {
        return descript;
    }

    public int getCreation_year() {
        return creation_year;
    }
}

package com.bytedance.android.lesson.restapi.solution.bean;

import com.google.gson.annotations.SerializedName;

import retrofit2.http.GET;

/**
 * @author Xavier.S
 * @date 2019.01.20 14:18
 */
public class Feed {
    // TODO-C2 (1) Implement your Feed Bean here according to the response json

    @SerializedName("student_id")   String id;
    @SerializedName("user_name")    String name;
    @SerializedName("image_url")    String iurl;
    @SerializedName("video_url")    String vurl;


    public String getId()   { return id; }
    public void   setId()   {this.id = id;}

    public String getName() {return name;}
    public void   setName() {this.name = name;}

    public String getIurl() {return iurl;}
    public void setIurl(String iurl) { this.iurl = iurl; }

    public String getVurl() {return  vurl;}
    public void setVurl(String vurl) { this.vurl = vurl; }
}

package com.bytedance.android.lesson.restapi.solution.bean;

import com.google.gson.annotations.SerializedName;

/**
 * @author Xavier.S
 * @date 2019.01.18 17:53
 */
public class PostVideoResponse {

    // TODO-C2 (3) Implement your PostVideoResponse Bean here according to the response json
    @SerializedName("student_id") String id;
    @SerializedName("user_name")  String name;
    @SerializedName("image_url")  String iurl;
    @SerializedName("video_url")  String vurl;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setIurl(String iurl) {
        this.iurl = iurl;
    }

    public String getIurl() {
        return iurl;
    }

    public void setVurl(String vurl) {
        this.vurl = vurl;
    }

    public String getVurl() {
        return vurl;
    }
}

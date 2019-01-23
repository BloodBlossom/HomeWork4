package com.bytedance.android.lesson.restapi.solution.bean;

import com.google.gson.annotations.SerializedName;

/**
 * @author Xavier.S
 * @date 2019.01.17 18:08
 */
public class Cat {

    @SerializedName("url") String url;

    public String getUrl(){
        return url;
    }

    public void setUrl(){
        this.url = url;
    }

    // TODO-C1 (1) Implement your Cat Bean here according to the response json
}

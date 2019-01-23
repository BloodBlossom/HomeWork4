package com.bytedance.android.lesson.restapi.solution.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import retrofit2.http.GET;

/**
 * @author Xavier.S
 * @date 2019.01.20 14:17
 */
public class FeedResponse {

    // TODO-C2 (2) Implement your FeedResponse Bean here according to the response json
    @SerializedName("feeds")
    private List<Feed> feedList = new ArrayList<Feed>();

    @SerializedName("success")
    boolean success;


    public void setSuccest()    {
        this.success = success;
    }

    public boolean getSuccess() {
        return success;
    }


    public void setFeedList(List<Feed> feedList) {
        this.feedList = feedList;
    }

    public List<Feed> getFeedList() {
        return feedList;
    }
}

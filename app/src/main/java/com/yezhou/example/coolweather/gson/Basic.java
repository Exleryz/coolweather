package com.yezhou.example.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/12/17.
 */

public class Basic {

    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weather_id;

    public Update update;
    public class Update {
        @SerializedName("loc")
        public String updateTime;
    }
}
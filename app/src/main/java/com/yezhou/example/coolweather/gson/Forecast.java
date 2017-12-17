package com.yezhou.example.coolweather.gson;


import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/12/17.
 */

public class Forecast {    // 单日天气实体类

    public String date;

    @SerializedName("tmp")
    public Temperatgure temperatgure;

    @SerializedName("cond")
    public More more;

    public class Temperatgure {

        public String max;
        public String min;
    }

    public class More {

        @SerializedName("txt_d")
        public String info;
    }
}

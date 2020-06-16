package com.moyu.coolweather.gson;

import com.google.gson.annotations.SerializedName;

public class Now {
    @SerializedName("tmp")
    public String temperature;
    @SerializedName("cond")
    public More mroe;
    public class More{
        @SerializedName("txt")
        public String info;
    }
}

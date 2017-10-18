package com.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 杜功华 on 2017/10/18.
 */

public class Basic {
    @SerializedName("city")
    public String cityName ;
    @SerializedName("id")
    public String weatherId ;

    public Update update ;

    public class Update{
        @SerializedName("loc")
        public String updateTime ;
    }

}

package com.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 杜功华 on 2017/10/18.
 */

public class Forecast {
    public String date;

    public Tmp tmp ;
    @SerializedName("cond")
    public More more ;

    public class Tmp{
        public String max ;
        public String min;
    }

    public class More{
        public String txt_d ;
    }

}

package com.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 杜功华 on 2017/10/18.
 */

public class Now {
    public String tmp ;
    @SerializedName("cond")
    public More more ;
    public class More{
        public String txt ;
    }
}

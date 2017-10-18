package com.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 杜功华 on 2017/10/18.
 */

public class Suggestion {
    @SerializedName("comf")
    public Comfort comfort ;
    @SerializedName("cw")
    public CarWash carWash;

    public Sport sport ;

    public class Comfort{
        public String txt ;
    }

    public class CarWash{
        public String txt ;
    }

    public class Sport{
        public String txt ;
    }
}

package com.coolweather.android.db;

import org.litepal.crud.DataSupport;

/**
 * Created by 杜功华 on 2017/10/17.
 */

public class County extends DataSupport{
    private  int id  ;
    private  String countyName;
    private int cityId ;
    private int weatherId ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(int weatherId) {
        this.weatherId = weatherId;
    }
}

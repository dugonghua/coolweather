package com.coolweather.android.util;

import android.text.TextUtils;

import com.coolweather.android.db.City;
import com.coolweather.android.db.County;
import com.coolweather.android.db.Province;
import com.coolweather.android.gson.Weather;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by 杜功华 on 2017/10/17.
 */

public class Utility {
    /**
     * 解析和处理服务器返回的省级数据
     */

    public static boolean handleProvinceResponse(String response){
        if (!TextUtils.isEmpty(response)){
            try {
                JSONArray allProvinces  = new JSONArray(response);
                for (int i = 0 ; i<allProvinces.length();i++){
                    JSONObject provincesObject = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provincesObject.getString("name"));
                    province.setProvinceCode(provincesObject.getInt("id"));
                    province.save();
                }
                return  true ;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return  false;
    }
    /**
     * 解析和处理服务器返回的市级数据
     */

    public static boolean handleCityResponse(String response,int provincesId ){
        if (!TextUtils.isEmpty(response)){
            try {
                JSONArray allcities  = new JSONArray(response);
                for (int i = 0 ; i<allcities.length();i++){
                    JSONObject cityObject = allcities.getJSONObject(i);
                    City city = new City();

                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProviceId(provincesId);
                    city.save();
                }
                return  true ;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return  false;
    }
    /**
     * 解析和处理服务器返回的县级数据
     */

    public static boolean handleCountyResponse(String response,int cityId ){
        if (!TextUtils.isEmpty(response)){
            try {
                JSONArray allcounties  = new JSONArray(response);
                for (int i = 0 ; i<allcounties.length();i++){
                    JSONObject countyObject = allcounties.getJSONObject(i);
                    County county = new County();

                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return  true ;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return  false;
    }

    /**
     * 将返回的json数据解析成weather实体类
     */
    public static Weather handleWeatherResponse(String response){
        try {
            JSONObject jsonObject =new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather");
            String weatherContent = jsonArray.getJSONObject(0).toString();
            return  new Gson().fromJson(weatherContent,Weather.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}

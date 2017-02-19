package com.coolweather.android.util;

import android.text.TextUtils;

import com.coolweather.android.R;
import com.coolweather.android.db.City;
import com.coolweather.android.db.County;
import com.coolweather.android.db.Province;
import com.coolweather.android.gson.Weather;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;

/**
 * Created by 刘通 on 2017/1/31.
 */

public class Utility {

    public static boolean handleProvinceResponse(String response){
        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray allProvinces = new JSONArray(response);
                for(int i = 0;i < allProvinces.length();i ++){
                    JSONObject provinceObject = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean handleCityResponse(String response,int provinceId){
        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray allCities = new JSONArray(response);
                for(int i = 0;i < allCities.length();i ++){
                    JSONObject cityObject = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean handleCountyResponse(String response,int cityId){
        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray allCounties = new JSONArray(response);
                for(int i = 0;i < allCounties.length();i ++){
                    JSONObject countryObject = allCounties.getJSONObject(i);
                    County county = new County();
                    county.setCountyNmae(countryObject.getString("name"));
                    county.setWeatherId(countryObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    public static Weather handleWeatherResponse(String response){
        try{
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather5");
            String weatherContent = jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(weatherContent,Weather.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static int handleAnimationPicResponse(){
        Random random = new Random();
        int randNumber = random.nextInt(30);
        int picId = R.drawable.pic_001;
        switch (randNumber){
            case 0: picId = R.drawable.pic_001;
            break;
            case 1: picId = R.drawable.pic_002;
            break;
            case 2: picId = R.drawable.pic_003;
            break;
            case 3: picId = R.drawable.pic_004;
            break;
            case 4: picId = R.drawable.pic_005;
            break;
            case 5: picId = R.drawable.pic_006;
            break;
            case 6: picId = R.drawable.pic_007;
            break;
            case 7: picId = R.drawable.pic_008;
            break;
            case 8: picId = R.drawable.pic_009;
            break;
            case 9: picId = R.drawable.pic_010;
            break;
            case 10: picId = R.drawable.pic_011;
            break;
            case 11: picId = R.drawable.pic_012;
            break;
            case 12: picId = R.drawable.pic_013;
            break;
            case 13: picId = R.drawable.pic_014;
            break;
            case 14: picId = R.drawable.pic_015;
            break;
            case 15: picId = R.drawable.pic_016;
            break;
            case 16: picId = R.drawable.pic_017;
            break;
            case 17: picId = R.drawable.pic_018;
            break;
            case 18: picId = R.drawable.pic_019;
            break;
            case 19: picId = R.drawable.pic_020;
            break;
            case 20: picId = R.drawable.pic_021;
            break;
            case 21: picId = R.drawable.pic_022;
            break;
            case 22: picId = R.drawable.pic_023;
            break;
            case 23: picId = R.drawable.pic_024;
            break;
            case 24: picId = R.drawable.pic_025;
            break;
            case 25: picId = R.drawable.pic_026;
            break;
            case 26: picId = R.drawable.pic_027;
            break;
            case 27: picId = R.drawable.pic_028;
            break;
            case 28: picId = R.drawable.pic_029;
            break;
            case 29: picId = R.drawable.pic_030;
            break;
            case 30: picId = R.drawable.pic_031;
            break;
        }
            return picId;
    }

    public static String handleWeatherPicResponse(String response){
        String picId;
        switch(response){
            case "晴":picId="100.png";
                break;
            case "多云":picId="101.png";
                break;
            case "少云":picId="102.png";
                break;
            case "晴间多云":picId="103.png";
                break;
            case "阴":picId="104.png";
                break;
            case "有风":picId="200.png";
                break;
            case "平静":picId="201.png";
                break;
            case "微风":picId="202.png";
                break;
            case "和风":picId="203.png";
                break;
            case "清风":picId="204.png";
                break;
            case "强风/劲风":picId="205.png";
                break;
            case "疾风":picId="206.png";
                break;
            case "大风":picId="207.png";
                break;
            case "烈风":picId="208.png";
                break;
            case "风暴":picId="209.png";
                break;
            case "狂爆风":picId="210.png";
                break;
            case "飓风":picId="211.png";
                break;
            case "龙卷风":picId="212.png";
                break;
            case "热带风暴":picId="213.png";
                break;
            case "阵雨":picId="300.png";
                break;
            case "强阵雨":picId="301.png";
                break;
            case "雷阵雨":picId="302.png";
                break;
            case "强雷阵雨":picId="303.png";
                break;
            case "雷阵雨伴有冰雹":picId="304.png";
                break;
            case "小雨":picId="305.png";
                break;
            case "中雨":picId="306.png";
                break;
            case "大雨":picId="307.png";
                break;
            case "极端降雨":picId="308.png";
                break;
            case "毛毛雨/细雨":picId="309.png";
                break;
            case "暴雨":picId="310.png";
                break;
            case "大暴雨":picId="311.png";
                break;
            case "特大暴雨":picId="312.png";
                break;
            case "冻雨":picId="313.png";
                break;
            case "小雪":picId="400.png";
                break;
            case "中雪":picId="401.png";
                break;
            case "大雪":picId="402.png";
                break;
            case "暴雪":picId="403.png";
                break;
            case "雨夹雪":picId="404.png";
                break;
            case "雨雪天气":picId="405.png";
                break;
            case "阵雨夹雪":picId="406.png";
                break;
            case "阵雪":picId="407.png";
                break;
            case "薄雾":picId="500.png";
                break;
            case "雾":picId="501.png";
                break;
            case "霾":picId="502.png";
                break;
            case "扬沙":picId="503.png";
                break;
            case "浮尘":picId="504.png";
                break;
            case "沙尘暴":picId="507.png";
                break;
            case "强沙尘暴":picId="508.png";
                break;
            case "热":picId="900.png";
                break;
            case "冷":picId="901.png";
                break;
            default:picId="999.png";
                break;
        }
        return "http://files.heweather.com/cond_icon/" + picId;
    }
}

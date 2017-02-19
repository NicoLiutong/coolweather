package com.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 刘通 on 2017/2/1.
 */

public class Now {

    @SerializedName("tmp")
    public String temperature;

    @SerializedName("cond")
    public More more;

    @SerializedName("hum")
    public String relativeHumidity;

    public class More{

        @SerializedName("txt")
        public String info;
    }

    @SerializedName("wind")
    public Wind wind;

    public class Wind{
        @SerializedName("dir")
        public String windDirection;

        @SerializedName("sc")
        public String windPower;
    }
}

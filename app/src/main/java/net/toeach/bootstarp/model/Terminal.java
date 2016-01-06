package net.toeach.bootstarp.model;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 终端信息对象
 * Created by Administrator on 2016/1/5.
 */
public class Terminal {
    @JSONField(name = "api_version")
    private String apiVersion;  // 接口版本
    @JSONField(name = "app_version")
    private int appVersion;  // 应用版本
    @JSONField(name = "os_name")
    private String os;  // OS系统名称
    @JSONField(name = "os_version")
    private String osVersion;  // OS版本
    @JSONField(name = "imsi")
    private String imsi;  // 终端IMSI
    @JSONField(name = "imei")
    private String imei;  // 终端IMEI
    @JSONField(name = "model")
    private String model;  // 终端型号
    @JSONField(name = "screen_width")
    private int screenWidth;  // 屏幕宽度
    @JSONField(name = "screen_height")
    private int screenHeight;  // 屏幕高度

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public int getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(int appVersion) {
        this.appVersion = appVersion;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }

    @Override
    public String toString() {
        return "Terminal{" +
                "apiVersion=" + apiVersion +
                ", appVersion=" + appVersion +
                ", os='" + os + '\'' +
                ", osVersion='" + osVersion + '\'' +
                ", imsi='" + imsi + '\'' +
                ", imei='" + imei + '\'' +
                ", model='" + model + '\'' +
                ", screenWidth=" + screenWidth +
                ", screenHeight=" + screenHeight +
                '}';
    }
}

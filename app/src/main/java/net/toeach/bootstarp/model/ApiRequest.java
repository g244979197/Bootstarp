package net.toeach.bootstarp.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Map;

/**
 * API接口请求对象
 * Created by Administrator on 2016/1/5.
 */
public class ApiRequest {
    @JSONField(name = "id")
    private String id;  // 请求唯一编号
    @JSONField(name = "url")
    private String url;  // 接口地址
    @JSONField(name = "user_code")
    private String userCode;  // 用户编号
    @JSONField(name = "token")
    private String token;  // 请求token
    @JSONField(name = "ex")
    private Terminal ex;  // 终端信息
    @JSONField(name = "data")
    private Map<String, String> data;  // 接口数据

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Terminal getEx() {
        return ex;
    }

    public void setEx(Terminal ex) {
        this.ex = ex;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ApiRequest{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", userCode='" + userCode + '\'' +
                ", token='" + token + '\'' +
                ", ex=" + ex +
                ", data=" + data +
                '}';
    }
}

package net.toeach.bootstarp.model;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * API接口返回对象
 * Created by Administrator on 2016/1/5.
 */
public class ApiResponse<T> {
    @JSONField(name = "id")
    private long id;  // 请求唯一编号
    @JSONField(name = "result")
    private int result;  // 返回码
    @JSONField(name = "result_desc")
    private String resultDesc;  // 返回码说明
    @JSONField(name = "data")
    private T data;  // 返回数据对象

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "id=" + id +
                ", result=" + result +
                ", resultDesc='" + resultDesc + '\'' +
                ", data=" + data +
                '}';
    }
}

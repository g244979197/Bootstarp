package net.toeach.bootstarp;

import com.alibaba.fastjson.JSON;

import junit.framework.TestCase;

import net.toeach.bootstarp.model.ApiRequest;
import net.toeach.bootstarp.model.Terminal;
import net.toeach.bootstarp.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Administrator on 2016/1/5.
 */
public class ApiRequestTest {
    public static void main(String[] args) {
        ApiRequest req = new ApiRequest();
        req.setId(UUID.randomUUID().toString());
        req.setUrl("/user/register");
        req.setUserCode("abcdesdf");
        req.setToken("1234565");

        Terminal ex = new Terminal();
        ex.setApiVersion("1.1");
        ex.setAppVersion(9);
        ex.setImei("123213212");
        ex.setImsi("1123123123");
        ex.setModel("Lenovo lemon");
        req.setEx(ex);

        Map<String, String> data = new HashMap<>();
        data.put("key1", "111");
        data.put("key2", "222");
        req.setData(data);

        String text = JSON.toJSONString(req);
        System.out.println("req1:" + text);
    }
}

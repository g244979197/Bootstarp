package net.toeach.bootstarp.business;

import android.os.Handler;

import net.toeach.bootstarp.model.ApiRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/1/6.
 */
public class MyManager extends BaseManager {
    private static MyManager instance;

    private MyManager() {
    }

    public static MyManager getInstance() {
        if (instance == null) {
            instance = new MyManager();
        }
        return instance;
    }

    public void getUser(String key1, String key2, Handler handler) {
        ApiRequest req = getRequest();
        req.setUrl("/user/info");

        Map<String, String> data = new HashMap<>();
        data.put("key1", key1);
        data.put("key2", key2);
        req.setData(data);

        sendRequest(req, handler, new Callback() {
            @Override
            public void process(String response) {

            }
        });
    }
}

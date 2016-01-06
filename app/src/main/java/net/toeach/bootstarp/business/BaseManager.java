package net.toeach.bootstarp.business;

import android.os.Handler;
import android.os.Message;

import com.alibaba.fastjson.JSON;

import net.toeach.bootstarp.AppConfig;
import net.toeach.bootstarp.BootstrapApplication;
import net.toeach.bootstarp.model.ApiRequest;
import net.toeach.bootstarp.model.Terminal;

import org.xutils.common.util.LogUtil;

import java.io.IOException;
import java.util.UUID;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/1/6.
 */
public class BaseManager {
    public static final int MSG_REQ_SUCCESS = 1001;// 请求数据成功
    public static final int MSG_REQ_FAILURE = 1002;// 请求数据失败
    public static final int MSG_ERROR = 1003;// 应用错误

    /**
     * 发送消息
     *
     * @param handler Handler对象
     * @param what    what
     */
    protected void handleMessage(Handler handler, int what) {
        handleMessage(handler, what, null);
    }

    /**
     * 发送消息
     *
     * @param handler Handler对象
     * @param what    what
     * @param obj     传值对象
     */
    protected void handleMessage(Handler handler, int what, Object obj) {
        if (handler != null) {
            Message msg = handler.obtainMessage();
            msg.what = what;
            if (obj != null) {
                msg.obj = obj;
            }
            handler.sendMessage(msg);
        }
    }

    /**
     * 发送错误处理消息
     *
     * @param handler Handler对象
     * @param err     错误代码
     */
    protected void handleError(Handler handler, String err) {
        // 发送消息
        if (handler != null) {
            Message msg = handler.obtainMessage();
            msg.what = MSG_ERROR;
            msg.obj = err;
            handler.sendMessage(msg);
        }
    }

    /**
     * 发送请求
     *
     * @param req      请求参数
     * @param handler  Handler对象
     * @param callback 回调函数
     */
    protected void sendRequest(final ApiRequest req, final Handler handler, final Callback callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String url = AppConfig.BASE_URL + req.getUrl();
                    MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
                    RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(req));
                    Request request = new Request.Builder()
                            .url(url)
                            .post(body)
                            .build();

                    Call call = new OkHttpClient().newCall(request);
                    call.enqueue(new okhttp3.Callback() {
                        @Override
                        public void onResponse(Response response) throws IOException {
                            // 打印响应数据
                            LogUtil.d("response = " + response.toString());
                            callback.process(response.toString());
                        }

                        @Override
                        public void onFailure(Request request, IOException e) {
                            e.printStackTrace();
                            handleMessage(handler, MSG_REQ_FAILURE, e);// 发送消息通知UI
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                    handleError(handler, e.getMessage());// 抛出系统错误
                }
            }
        }).start();
    }

    /**
     * 生成Request对象
     *
     * @return
     */
    protected ApiRequest getRequest() {
        ApiRequest req = new ApiRequest();
        req.setId(UUID.randomUUID().toString());
        req.setUserCode("SDFABSDFSDFSDF");
        req.setToken("1232323");

        // 终端信息
        Terminal terminal = BootstrapApplication.getInstance().getTerminal();
        req.setEx(terminal);

        return req;
    }

    public interface Callback {
        /**
         * 处理返回的结果
         *
         * @param response 返回结果
         */
        void process(String response);
    }
}

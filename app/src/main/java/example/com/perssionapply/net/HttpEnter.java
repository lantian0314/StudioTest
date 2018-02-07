package example.com.perssionapply.net;


import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.IOException;

import example.com.perssionapply.MainActivity;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by xingyatong on 2018/2/7.
 */
public class HttpEnter {

    private static Context mContext;

    public void getRequest(Context context, String requestUrl) {
        mContext = context;
        try {
            //得到OkHttpClient对象
            OkHttpClient mOkHttpClient = new OkHttpClient();
            //构造Request对象
            Request.Builder builder = new Request.Builder();
            Request request = builder.get().url(requestUrl).build();
            //将Request封装为Call
            Call mCall = mOkHttpClient.newCall(request);
            //开始执行Call
            //Response mResponse= mCall.execute();//同步方法
            mCall.enqueue(new Callback() {//异步执行方法
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    int code = response.code();
                    String result = response.body().toString();
                    Message message = new Message();
                    message.what = MSG_GETSTATE;
                    message.obj = code;
                    mHandler.sendMessage(message);
                }
            });
        } catch (Exception e) {

        }
    }

    public void postRequest(String requestUrl, JSONObject mJsonObject) {
        try {
            //初始化OkHttpClient
            OkHttpClient mOkHttpClient = new OkHttpClient();
            //构造Json的请求对象
            RequestBody mRequestBody = RequestBody.create(MediaType.parse("text/plain;chaset=utf-8"), mJsonObject.toString());
            //构造Request对象
            Request.Builder mBuilder=new Request.Builder();
            Request request=mBuilder.post(mRequestBody).url(requestUrl).build();
            //构造Call对象
            Call mCall=mOkHttpClient.newCall(request);
            mCall.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {

                }
            });
        } catch (Exception e) {

        }
    }

    private static final int MSG_GETSTATE = 10;
    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case MSG_GETSTATE:
                    int code = (int) msg.obj;
                    Toast.makeText(mContext, "Get Result code : " + code, Toast.LENGTH_LONG).show();
                    break;
            }
        }
    };
}

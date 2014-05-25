package org.tmp.shopclient.http;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestHandle;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.ResponseHandlerInterface;

import org.apache.http.Header;
import org.tmp.shopclient.utils.Constant;

public class HttpConnection {

    private static final HttpConnection httpInterfce = new HttpConnection();
    private static AsyncHttpClient client  = new AsyncHttpClient();
    private Handler handler ;
    private Context context ;

    private HttpConnection(){

    }
    public static HttpConnection getInstance(){
        //设置http链接超时为3秒
        client.setTimeout(3000);
        return httpInterfce;
    }


    public RequestHandle executeSample(Context context ,Handler handler ,String url,RequestParams params, ResponseHandlerInterface responseHandler) {
        this.handler = handler;
        this.context = context;
        return client.post(url, params, responseHandler);
    }

    public ResponseHandlerInterface getResponseHandler() {

        return new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers,
                                  String responseBody) {
                super.onSuccess(statusCode, headers, responseBody);
                System.out.println("statusCode--->"+statusCode);
                Message msg = handler.obtainMessage();
                msg.what = Constant.SUCCESS;
                msg.obj = responseBody;
                handler.sendMessage(msg);
            }

            @Override
            public void onStart() {
            }


            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
                Message msg = handler.obtainMessage();
                msg.what = Constant.FAILED ;
                msg.obj = null;
                handler.sendMessage(msg);
            }
        };
    }
}

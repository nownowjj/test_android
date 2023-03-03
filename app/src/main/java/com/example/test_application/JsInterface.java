package com.example.test_application;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

public class JsInterface {

    Context context;
    Activity activity;
    WebView webView;

    public JsInterface(Context context, WebView webView){
        this.context = context;
        this.activity = (Activity) context;
        this.webView = webView;
    }

    @JavascriptInterface
    public void callAppFunc(String msg){
        Log.d("webview##", "msg from client : " + msg);
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //callFromApp function을 호출하는 것 처럼
                //이름을 같게 해주어야한다.
                webView.loadUrl("javascript:callFromApp('from app11')");
            }
        });
    }
}

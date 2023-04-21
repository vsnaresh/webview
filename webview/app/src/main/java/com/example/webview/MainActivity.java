package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView = findViewById(R.id.webview);
        WebView.setWebContentsDebuggingEnabled(true);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
//        webView.getSettings().setAppCacheMaxSize(1024*1024*8);
//        webView.getSettings().setAppCachePath(getApplicationContext().getFilesDir().getAbsolutePath() + "/cache");
//        webView.getSettings().setAppCacheEnabled(true);
        webView.loadUrl("https://www.google.co.in");

        Button buttonCC = (Button) findViewById(R.id.clearCache);
        buttonCC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                webView.clearCache(true);
            }
        });

        Button buttonGTG = (Button) findViewById(R.id.GoToGoogle);
        buttonGTG.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                webView.loadUrl("https://www.google.co.in");
            }
        });

        Button buttonN = (Button) findViewById(R.id.LoadCacheElseNetwork);
        buttonN.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                webSettings.setCacheMode( WebSettings.LOAD_CACHE_ELSE_NETWORK);
                webView.loadUrl("https://retail.sc.com/retail/sg/ibanking/#/payments/sg/home");
//                webView.loadUrl("http://192.168.1.3:8080/react");

            }
        });

        Button buttonLC = (Button) findViewById(R.id.LoadFromCache);
        buttonLC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                webSettings.setCacheMode( WebSettings.LOAD_CACHE_ONLY);
                webView.loadUrl("https://retail.sc.com/retail/sg/ibanking/#/payments/sg/home");
//                webView.loadUrl("http://192.168.1.3:8080/react");

            }
        });

        Button buttonLD = (Button) findViewById(R.id.LoadDefault);
        buttonLD.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                webSettings.setCacheMode( WebSettings.LOAD_DEFAULT);
                webView.loadUrl("https://retail.sc.com/retail/sg/ibanking/#/payments/sg/home");
//                webView.loadUrl("http://192.168.1.3:8080/react");

            }
        });
    }
}
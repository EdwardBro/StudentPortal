package com.example.studentportal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebviewActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_webview);

            Intent intent = getIntent();
            String myURL = intent.getStringExtra(MainActivity.EXTRATEXT_URL);
            WebView myWebView = findViewById(R.id.webview);
            myWebView.setWebViewClient(new WebViewClient());
            myWebView.loadUrl(myURL);
        }
    }


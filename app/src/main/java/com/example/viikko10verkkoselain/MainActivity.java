package com.example.viikko10verkkoselain;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private WebView webview;
    private TextInputEditText URL;
    private String nykyinen = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webview = findViewById(R.id.webview);
        URL = findViewById(R.id.URL);
        webview.setWebViewClient(new WebViewClient());
        webview.getSettings().setJavaScriptEnabled(true);
    }

    public void haeURL(View v) {
        nykyinen = URL.getText().toString();
        if (nykyinen.equals("index.html")) {
            webview.loadUrl("File:///android_asset/index.html");
        } else {
            Muisti muisti = Muisti.getInstance();
            muisti.addEdellinen(nykyinen);
            webview.loadUrl("http://" + nykyinen);
        }
    }

    public void paivita(View v) {
        webview.reload();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void javascript(View v) {
         webview.evaluateJavascript("javascript:shoutOut()", null);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void palauta(View v) {
        webview.evaluateJavascript("javascript:initialize()", null);
    }

    public void seuraava(View v) {
        Muisti muisti = Muisti.getInstance();
        webview.loadUrl("http://" + muisti.getSeuraava());
    }

    public void edellinen(View v) {
        Muisti muisti = Muisti.getInstance();
        webview.loadUrl("http://" + muisti.getEdellinen());
    }
}

package com.woyyds.zhaoyaojing;


import android.os.Build;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        webview = new WebView(this);
        WebSettings settings = webview.getSettings();

        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);  // ⭐ 开启 localStorage 和 sessionStorage
        settings.setDatabaseEnabled(true);    // 可选，但推荐
        settings.setAllowFileAccess(true);
        settings.setAllowContentAccess(true);

        webview.setWebViewClient(new WebViewClient());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true);
        }

        webview.loadUrl("https://woyyds.com/vue");
        setContentView(webview);
    }

    @Override
    public void onBackPressed() {
        if (webview.canGoBack()) {
            webview.goBack();
        } else {
            super.onBackPressed();
        }
    }
}

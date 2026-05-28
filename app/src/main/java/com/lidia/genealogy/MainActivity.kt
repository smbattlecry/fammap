package com.lidia.genealogy

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val webView = WebView(this).apply {
            settings.apply {
                javaScriptEnabled = true
                domStorageEnabled = true
                // Zoom handled by our JS — disable native WebView zoom
                // so pinch events go straight to our touch handlers
                setSupportZoom(false)
                builtInZoomControls = false
                displayZoomControls = false
                // Improve rendering
                useWideViewPort = true
                loadWithOverviewMode = true
            }
            setBackgroundColor(Color.WHITE)
            webViewClient = WebViewClient()
            loadUrl("file:///android_asset/index.html")
        }
        setContentView(webView)
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val wv = findViewById<WebView>(android.R.id.content)
        if (wv?.canGoBack() == true) wv.goBack() else super.onBackPressed()
    }
}

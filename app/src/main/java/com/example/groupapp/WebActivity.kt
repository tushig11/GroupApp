package com.example.groupapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        web.webViewClient = WebViewClient()
        web.settings.javaScriptEnabled = true
        intent.extras?.getString("url")?.let{ web.loadUrl(it) }
    }
}
package com.example.kotlindaggerunittest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.kotlindaggerunittest.analytics.MyLogger
import com.example.kotlindaggerunittest.analytics.ThirdPartyAnalyticsWrapper
import com.example.kotlindaggerunittest.analytics.error
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MyLogger {

    @Inject
    lateinit var thirdPartyAnalyticsWrapper: ThirdPartyAnalyticsWrapper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as MyApplication).component().inject(this)

        val tv = findViewById(R.id.tv_hello) as TextView
        tv.setText(thirdPartyAnalyticsWrapper.getMyHello())

        error { "test error" }
    }
}

package com.example.kotlindaggerunittest

import com.example.kotlindaggerunittest.analytics.MyLogger
import com.example.kotlindaggerunittest.analytics.ThirdPartyAnalyticsWrapper
import com.example.kotlindaggerunittest.analytics.error
import javax.inject.Inject

class MyNonLifecycleClass : MyLogger {

    @Inject
    lateinit var thirdPartyAnalyticsWrapper: ThirdPartyAnalyticsWrapper

    init {
        MyApplication.myComponent.inject(this)
    }

    fun makeError() {
        error { "error" }
    }
}

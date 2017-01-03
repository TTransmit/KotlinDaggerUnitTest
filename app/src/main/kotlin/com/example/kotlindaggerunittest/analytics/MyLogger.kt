package com.example.kotlindaggerunittest.analytics

import android.util.Log
import com.example.kotlindaggerunittest.MyApplication
import javax.inject.Inject

interface MyLogger {
    fun getThirdPartyHolder() : ThirdPartyAnalyticsWrapperHolder = ThirdPartyAnalyticsWrapperHolder()
}

class ThirdPartyAnalyticsWrapperHolder {
    @Inject
    lateinit var thirdPartyAnalyticsWrapper : ThirdPartyAnalyticsWrapper

    init {
        MyApplication.myComponent.inject(this)
    }
}

fun MyLogger.error(message: () -> Any?) {
    Log.e(javaClass.toString(), message()?.toString() ?: "null")
    getThirdPartyHolder().thirdPartyAnalyticsWrapper.trackLog(message()?.toString() ?: "null")
}

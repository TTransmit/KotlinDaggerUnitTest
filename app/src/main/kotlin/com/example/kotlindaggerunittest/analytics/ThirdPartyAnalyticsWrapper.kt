package com.example.kotlindaggerunittest.analytics

import com.example.kotlindaggerunittest.MyApplication
import javax.inject.Inject

open class ThirdPartyAnalyticsWrapper @Inject constructor() {

    @Inject
    lateinit var thirdPartyLogger: ThirdPartyLogger

    var hello = "hello"

    init {
        inject()
    }

    open fun inject() {
        MyApplication.myComponent.inject(this)
    }

    open fun getMyHello() : String {
        return hello
    }

    open fun trackLog(message: String) {
        thirdPartyLogger.logStuff(message)
    }

}

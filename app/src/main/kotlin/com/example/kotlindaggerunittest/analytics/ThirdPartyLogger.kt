package com.example.kotlindaggerunittest.analytics

import android.util.Log
import javax.inject.Inject

open class ThirdPartyLogger @Inject constructor() {

    fun logStuff(message: String) {
        Log.d("ThirdPartyLogger", message)
    }

}

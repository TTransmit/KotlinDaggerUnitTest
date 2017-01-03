package com.example.kotlindaggerunittest

import android.app.Application

open class MyApplication : Application() {

    companion object {
        lateinit var myComponent: MyComponent
    }

    override fun onCreate()  {
        buildDaggerGraph()
    }

    open fun buildDaggerGraph() {
        myComponent = DaggerMyComponent.builder().build()
        myComponent.inject(this)
    }

    fun component(): MyComponent {
        return myComponent
    }

}

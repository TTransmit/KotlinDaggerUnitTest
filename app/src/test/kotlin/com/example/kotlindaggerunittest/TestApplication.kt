package com.example.kotlindaggerunittest

class TestApplication : MyApplication() {

    override fun buildDaggerGraph() {
        myComponent = DaggerTestComponent.builder().build()
        myComponent.inject(this)
    }

}

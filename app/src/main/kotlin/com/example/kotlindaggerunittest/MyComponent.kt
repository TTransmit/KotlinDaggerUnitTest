package com.example.kotlindaggerunittest

import com.example.kotlindaggerunittest.analytics.ThirdPartyAnalyticsWrapper
import com.example.kotlindaggerunittest.analytics.ThirdPartyAnalyticsWrapperHolder
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(MyModule::class))
interface MyComponent {
    fun inject(myApplication: MyApplication)
    fun inject(mainActivity: MainActivity)
    fun inject(myNonLifecycleClass: MyNonLifecycleClass)
    fun inject(thirdPartyAnalyticsWrapper: ThirdPartyAnalyticsWrapper)
    fun inject(thirdPartyAnalyticsWrapperHolder: ThirdPartyAnalyticsWrapperHolder)
}

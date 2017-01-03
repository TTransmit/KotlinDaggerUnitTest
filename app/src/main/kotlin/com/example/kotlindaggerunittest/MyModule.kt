package com.example.kotlindaggerunittest

import com.example.kotlindaggerunittest.analytics.ThirdPartyAnalyticsWrapper
import com.example.kotlindaggerunittest.analytics.ThirdPartyLogger
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MyModule {

    @Singleton
    @Provides
    fun provideThirdPartyAnalyticsWrapper(): ThirdPartyAnalyticsWrapper {
        return ThirdPartyAnalyticsWrapper()
    }

    @Singleton
    @Provides
    fun provideThirdPartyLogger(): ThirdPartyLogger {
        return ThirdPartyLogger()
    }

}

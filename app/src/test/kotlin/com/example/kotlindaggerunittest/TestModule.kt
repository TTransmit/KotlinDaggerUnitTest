package com.example.kotlindaggerunittest

import com.example.kotlindaggerunittest.analytics.ThirdPartyAnalyticsWrapper
import com.example.kotlindaggerunittest.analytics.ThirdPartyLogger
import dagger.Module
import dagger.Provides
import org.mockito.Mockito.mock
import javax.inject.Singleton

/**
 * Created by Michael Richardson on 29/12/2016
 * Copyright (C) Sky UK Limited.  All rights reserved.
 */
@Module
class TestModule {

    @Singleton
    @Provides
    fun provideThirdPartyAnalyticsWrapper(): ThirdPartyAnalyticsWrapper {
        return mock(ThirdPartyAnalyticsWrapper::class.java)
    }

    @Singleton
    @Provides
    fun provideThirdPartyLogger(): ThirdPartyLogger {
        return mock(ThirdPartyLogger::class.java)
    }

}

package com.example.kotlindaggerunittest

import com.example.kotlindaggerunittest.analytics.ThirdPartyAnalyticsWrapper
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import org.robolectric.RobolectricGradleTestRunner
import org.robolectric.annotation.Config
import javax.inject.Inject

@Config(constants = BuildConfig::class, sdk = intArrayOf(21),
        packageName = "com.example.kotlindaggerunittest", application = TestApplication::class)
@RunWith(RobolectricGradleTestRunner::class)
class MyNonLifecycleClassTest {

    @Inject
    lateinit var thirdPartyAnalyticsWrapper: ThirdPartyAnalyticsWrapper

    val myNonLifecycleClass = MyNonLifecycleClass()

    @Before
    fun setUp() {
        (MyApplication.myComponent as TestComponent).inject(this)
        thirdPartyAnalyticsWrapper.inject()
    }

    @Test
    fun testAnalyticsWrappersTheSame() {
        assertEquals(thirdPartyAnalyticsWrapper, myNonLifecycleClass.thirdPartyAnalyticsWrapper)

        `when`(thirdPartyAnalyticsWrapper.getMyHello()).thenReturn("test")

        assertEquals("test", myNonLifecycleClass.thirdPartyAnalyticsWrapper.getMyHello())
    }

    @Test
    fun testMakeError() {
        myNonLifecycleClass.makeError()
        verify(thirdPartyAnalyticsWrapper).trackLog("error")
    }

    @Test
    fun testVerifyDoesNotCallItself() {
        verify(thirdPartyAnalyticsWrapper, never()).trackLog("test2")
    }

}

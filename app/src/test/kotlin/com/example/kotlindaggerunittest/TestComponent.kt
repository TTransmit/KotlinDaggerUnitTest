package com.example.kotlindaggerunittest

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(TestModule::class))
interface TestComponent : MyComponent {
    fun inject(myNonLifecycleClassTest: MyNonLifecycleClassTest)
}

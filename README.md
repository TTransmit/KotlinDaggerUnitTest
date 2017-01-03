# KotlinDaggerUnitTest
Demonstrates an issue with Kotlin 1.0.6 that annotations in the test project fail to generate code

The app compiles and runs fine. However, running the tests with `./gradlew testDebugUnitTest` or through Android Studio gives the error:
```
KotlinDaggerUnitTest/app/src/test/kotlin/com/example/kotlindaggerunittest/TestApplication.kt: (6, 23): Unresolved reference: DaggerTestComponent
```

Changing the `build.gradle` line `ext.kotlin_version = '1.0.6'` to `ext.kotlin_version = '1.0.5-3` fixes this. 

When using `ext.kotlin_version = '1.0.5-3'`, commenting out the line `kaptTest 'com.google.dagger:dagger-compiler:2.8'` from `app/build.gradle` gives the same error. This suggests that the error is associated with kaptTest.

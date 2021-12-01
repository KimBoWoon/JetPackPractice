plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-parcelize")
    id("androidx.navigation.safeargs.kotlin")
    id("dagger.hilt.android.plugin")
    id("kotlinx-serialization")
}

android {
    compileSdkVersion(com.bowoon.android.buildsrc.Versions.Apps.compileSdk)
    buildToolsVersion(com.bowoon.android.buildsrc.Versions.Apps.buildToolVersion)

    defaultConfig {
        applicationId = "com.bowoon.android.navigationpractice"
        minSdkVersion(com.bowoon.android.buildsrc.Versions.Apps.minSdk)
        targetSdkVersion(com.bowoon.android.buildsrc.Versions.Apps.targetSdk)
        versionCode = com.bowoon.android.buildsrc.Versions.Apps.versionCode
        versionName = com.bowoon.android.buildsrc.Versions.Apps.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation(com.bowoon.android.buildsrc.Dependencies.Kotlin.kotlin)
    implementation(com.bowoon.android.buildsrc.Dependencies.Ktx.core)
    implementation(com.bowoon.android.buildsrc.Dependencies.Appcompat.appcompat)
    implementation(com.bowoon.android.buildsrc.Dependencies.Google.material)
    implementation(com.bowoon.android.buildsrc.Dependencies.Layout.constraintlayout)
    implementation(com.bowoon.android.buildsrc.Dependencies.Ktx.lifecycleLiveData)
    implementation(com.bowoon.android.buildsrc.Dependencies.Ktx.viewmodel)
    testImplementation(com.bowoon.android.buildsrc.Dependencies.Test.junit)
    androidTestImplementation(com.bowoon.android.buildsrc.Dependencies.Test.junitExt)
    androidTestImplementation(com.bowoon.android.buildsrc.Dependencies.Test.espresso)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    implementation(com.bowoon.android.buildsrc.Dependencies.Ktx.navigation)
    implementation(com.bowoon.android.buildsrc.Dependencies.Ktx.navigationUi)

    implementation(com.bowoon.android.buildsrc.Dependencies.Ktx.fragment)

    implementation(com.bowoon.android.buildsrc.Dependencies.Retrofit2.retrofit)
    implementation(com.bowoon.android.buildsrc.Dependencies.Okhttp.loggingInterceptor)
    implementation(com.bowoon.android.buildsrc.Dependencies.Glide.glide)
    kapt(com.bowoon.android.buildsrc.Dependencies.Glide.compiler)
    implementation(com.bowoon.android.buildsrc.Dependencies.Ktx.room)
    kapt(com.bowoon.android.buildsrc.Dependencies.Ktx.roomCompiler)
    implementation(com.bowoon.android.buildsrc.Dependencies.Ktx.paging)

    implementation(com.bowoon.android.buildsrc.Dependencies.Hilt.hiltAndroid)
    kapt(com.bowoon.android.buildsrc.Dependencies.Hilt.hiltCompiler)

    implementation(com.bowoon.android.buildsrc.Dependencies.Google.gson)
    implementation(com.bowoon.android.buildsrc.Dependencies.Retrofit2.converterGson)

    implementation(com.bowoon.android.buildsrc.Dependencies.KotlinSerialization.kotlinSerialization)
    implementation(com.bowoon.android.buildsrc.Dependencies.KotlinSerialization.kotlinSerializationConverter)
    implementation(com.bowoon.android.buildsrc.Dependencies.KotlinSerialization.kotlinSerializationCore) // JVM dependency
}
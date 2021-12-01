plugins {
    kotlin("android")
    kotlin("kapt")
    id("com.android.application")
    id("kotlin-parcelize")
    id("androidx.navigation.safeargs.kotlin")
    id("dagger.hilt.android.plugin")
    id("kotlinx-serialization")
//    id("de.fayard.refreshVersions") version "0.23.0"
//    id("name.remal.check-dependency-updates") version "1.5.0"
}

android {
    setCompileSdkVersion(com.bowoon.android.buildsrc.Versions.Apps.compileSdk)
    buildToolsVersion = com.bowoon.android.buildsrc.Versions.Apps.buildToolVersion

    defaultConfig {
        applicationId = com.bowoon.android.buildsrc.Versions.Apps.applicationId
        minSdk = com.bowoon.android.buildsrc.Versions.Apps.minSdk
        targetSdk = com.bowoon.android.buildsrc.Versions.Apps.targetSdk
        versionCode = com.bowoon.android.buildsrc.Versions.Apps.versionCode
        versionName = com.bowoon.android.buildsrc.Versions.Apps.versionName

        testInstrumentationRunner = com.bowoon.android.buildsrc.Versions.Apps.testInstrumentationRunner
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile(com.bowoon.android.buildsrc.Versions.Apps.proguardFile), com.bowoon.android.buildsrc.Versions.Apps.proguardRules)
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = com.bowoon.android.buildsrc.Versions.Apps.jvmVersion
    }
    buildFeatures {
        dataBinding = true
    }
}

dependencies {
//    implementation(com.bowoon.android.buildsrc.Dependencies.Kotlin.kotlin)
//    implementation(com.bowoon.android.buildsrc.Dependencies.Ktx.core)
//    implementation(com.bowoon.android.buildsrc.Dependencies.Appcompat.appcompat)
//    implementation(com.bowoon.android.buildsrc.Dependencies.Google.material)
//    implementation(com.bowoon.android.buildsrc.Dependencies.Layout.constraintlayout)
//    implementation(com.bowoon.android.buildsrc.Dependencies.Ktx.lifecycleLiveData)
//    implementation(com.bowoon.android.buildsrc.Dependencies.Ktx.viewmodel)
//    testImplementation(com.bowoon.android.buildsrc.Dependencies.Test.junit)
//    androidTestImplementation(com.bowoon.android.buildsrc.Dependencies.Test.junitExt)
//    androidTestImplementation(com.bowoon.android.buildsrc.Dependencies.Test.espresso)
//    implementation(com.bowoon.android.buildsrc.Dependencies.Ktx.navigation)
//    implementation(com.bowoon.android.buildsrc.Dependencies.Ktx.navigationUi)
//    implementation(com.bowoon.android.buildsrc.Dependencies.Ktx.fragment)
//    implementation(com.bowoon.android.buildsrc.Dependencies.Retrofit2.retrofit)
//    implementation(com.bowoon.android.buildsrc.Dependencies.Okhttp.loggingInterceptor)
//    implementation(com.bowoon.android.buildsrc.Dependencies.Glide.glide)
//    kapt(com.bowoon.android.buildsrc.Dependencies.Glide.compiler)
//    implementation(com.bowoon.android.buildsrc.Dependencies.Ktx.room)
//    kapt(com.bowoon.android.buildsrc.Dependencies.Ktx.roomCompiler)
//    implementation(com.bowoon.android.buildsrc.Dependencies.Ktx.paging)
//    implementation(com.bowoon.android.buildsrc.Dependencies.Hilt.hiltAndroid)
//    kapt(com.bowoon.android.buildsrc.Dependencies.Hilt.hiltCompiler)
//    implementation(com.bowoon.android.buildsrc.Dependencies.Google.gson)
//    implementation(com.bowoon.android.buildsrc.Dependencies.Retrofit2.converterGson)
//    implementation(com.bowoon.android.buildsrc.Dependencies.KotlinSerialization.kotlinSerialization)
//    implementation(com.bowoon.android.buildsrc.Dependencies.KotlinSerialization.kotlinSerializationConverter)
//    implementation(com.bowoon.android.buildsrc.Dependencies.KotlinSerialization.kotlinSerializationCore) // JVM dependency

    with(com.bowoon.android.buildsrc.Dependencies.Kotlin) {
        arrayOf(
            kotlin
        )
    }.forEach {
        implementation(it)
    }

    with(com.bowoon.android.buildsrc.Dependencies.Ktx) {
        arrayOf(
            navigation,
            navigationUi,
            fragment,
            core,
            lifecycleLiveData,
            viewmodel,
            room,
            roomCompiler,
            paging
        )
    }.forEach {
        if (it == com.bowoon.android.buildsrc.Dependencies.Ktx.roomCompiler) {
            kapt(it)
        } else {
            implementation(it)
        }
    }

    with(com.bowoon.android.buildsrc.Dependencies.Appcompat) {
        arrayOf(
            appcompat
        )
    }.forEach {
        implementation(it)
    }

    with(com.bowoon.android.buildsrc.Dependencies.Google) {
        arrayOf(
            material,
            gson
        )
    }.forEach {
        implementation(it)
    }

    with(com.bowoon.android.buildsrc.Dependencies.Layout) {
        arrayOf(
            constraintlayout
        )
    }.forEach {
        implementation(it)
    }

    with(com.bowoon.android.buildsrc.Dependencies.Retrofit2) {
        arrayOf(
            retrofit,
            converterGson
        )
    }.forEach {
        implementation(it)
    }

    with(com.bowoon.android.buildsrc.Dependencies.Okhttp) {
        arrayOf(
            loggingInterceptor
        )
    }.forEach {
        implementation(it)
    }

    with(com.bowoon.android.buildsrc.Dependencies.Glide) {
        arrayOf(
            glide,
            compiler
        )
    }.forEach {
        if (it == com.bowoon.android.buildsrc.Dependencies.Glide.compiler) {
            kapt(it)
        } else {
            implementation(it)
        }
    }

    with(com.bowoon.android.buildsrc.Dependencies.Hilt) {
        arrayOf(
            hiltAndroid,
            hiltCompiler
        )
    }.forEach {
        if (it == com.bowoon.android.buildsrc.Dependencies.Hilt.hiltCompiler) {
            kapt(it)
        } else {
            implementation(it)
        }
    }

    with(com.bowoon.android.buildsrc.Dependencies.KotlinSerialization) {
        arrayOf(
            kotlinSerialization,
            kotlinSerializationConverter,
            kotlinSerializationCore
        )
    }.forEach {
        implementation(it)
    }

    with(com.bowoon.android.buildsrc.Dependencies.Test) {
        arrayOf(
            junit,
            junitExt,
            espresso
        )
    }.forEach {
        if (it == com.bowoon.android.buildsrc.Dependencies.Test.junit) {
            testImplementation(it)
        } else {
            androidTestImplementation(it)
        }
    }
}
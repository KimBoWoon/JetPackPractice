plugins {
    id("kotlin-kapt")
    id("kotlin-android")
    id("com.android.application")
    id("kotlin-parcelize")
    id("androidx.navigation.safeargs.kotlin")
    id("dagger.hilt.android.plugin")
    kotlin("plugin.serialization") //version "1.5.31"
//    id("de.fayard.refreshVersions") version "0.23.0"
//    id("name.remal.check-dependency-updates") version "1.5.0"
}

android {
    setCompileSdkVersion(Versions.Apps.compileSdk)
    buildToolsVersion = Versions.Apps.buildToolVersion

    defaultConfig {
        applicationId = Versions.Apps.applicationId
        minSdk = Versions.Apps.minSdk
        targetSdk = Versions.Apps.targetSdk
        versionCode = Versions.Apps.versionCode
        versionName = Versions.Apps.versionName

        testInstrumentationRunner = Versions.Apps.testInstrumentationRunner
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile(Versions.Apps.proguardFile), Versions.Apps.proguardRules)
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = Versions.Apps.jvmVersion
    }
    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    with(Dependencies.Kotlin) {
        arrayOf(
            kotlin
        )
    }.forEach {
        implementation(it)
    }

    with(Dependencies.Ktx) {
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
        if (it == Dependencies.Ktx.roomCompiler) {
            kapt(it)
        } else {
            implementation(it)
        }
    }

    with(Dependencies.Appcompat) {
        arrayOf(
            appcompat
        )
    }.forEach {
        implementation(it)
    }

    with(Dependencies.Google) {
        arrayOf(
            material,
            gson
        )
    }.forEach {
        implementation(it)
    }

    with(Dependencies.Layout) {
        arrayOf(
            constraintlayout
        )
    }.forEach {
        implementation(it)
    }

    with(Dependencies.Retrofit2) {
        arrayOf(
            retrofit,
            converterGson
        )
    }.forEach {
        implementation(it)
    }

    with(Dependencies.Okhttp) {
        arrayOf(
            loggingInterceptor
        )
    }.forEach {
        implementation(it)
    }

    with(Dependencies.Glide) {
        arrayOf(
            glide,
            compiler
        )
    }.forEach {
        if (it == Dependencies.Glide.compiler) {
            kapt(it)
        } else {
            implementation(it)
        }
    }

    with(Dependencies.Hilt) {
        arrayOf(
            hiltAndroid,
            hiltCompiler
        )
    }.forEach {
        if (it == Dependencies.Hilt.hiltCompiler) {
            kapt(it)
        } else {
            implementation(it)
        }
    }

    with(Dependencies.KotlinSerialization) {
        arrayOf(
            kotlinSerialization,
            kotlinSerializationConverter,
            kotlinSerializationCore
        )
    }.forEach {
        implementation(it)
    }

    with(Dependencies.ThirdParty) {
        arrayOf(
            okhttpProfiler
        )
    }.forEach {
        implementation(it)
    }

    with(Dependencies.Test) {
        arrayOf(
            junit,
            junitExt,
            espresso
        )
    }.forEach {
        if (it == Dependencies.Test.junit) {
            testImplementation(it)
        } else {
            androidTestImplementation(it)
        }
    }
}
package com.bowoon.android.buildsrc

object Dependencies {
    /* Kotlin */
    object Kotlin {
        const val kotlinJdk = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.Plugins.kotlin}"
        const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.Plugins.kotlin}"
        const val plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.Plugins.kotlin}"
        const val gradle = "com.android.tools.build:gradle:${Versions.Plugins.gradle}"
        const val serialization = "org.jetbrains.kotlin:kotlin-serialization:${Versions.Plugins.serialization}"
    }

    /* appcompat */
    object Appcompat {
        const val appcompat = "androidx.appcompat:appcompat:${Versions.Plugins.appcompat}"
    }

    /* ktx */
    object Ktx {
        const val core = "androidx.core:core-ktx:${Versions.Plugins.coreKtx}"
        // life cycle
        // 안드로이드에서 생명주기를 컨트롤 하기 위한 라이브러리
        // https://developer.android.com/jetpack/androidx/releases/lifecycle
        const val lifecycle = "androidx.lifecycle:lifecycle-extensions:${Versions.Plugins.lifecycleVersion}"
        const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.Plugins.lifecycleVersion}"
        const val lifecycleExtension = "androidx.lifecycle:lifecycle-extensions:${Versions.Plugins.lifecycleVersion}"
        const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.Plugins.lifecycleVersion}"
        // viewmodel
        const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Plugins.lifecycleVersion}"

        // fragment
        const val fragment = "androidx.fragment:fragment-ktx:${Versions.Plugins.fragmentVersion}"

        // navigation
        const val navigation = "androidx.navigation:navigation-fragment-ktx:${Versions.Plugins.navigationVersion}"
        const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.Plugins.navigationVersion}"

        // navigation safe argument
        const val safeArgument = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.Plugins.navigationVersion}"
        // use kotlin add build.gradle.kts.kts apply plugin: "androidx.navigation.safeargs.kotlin"

        // paging3
        const val paging = "androidx.paging:paging-runtime-ktx:${Versions.Plugins.pagingVersion}"

        // room
        const val room = "androidx.room:room-runtime:${Versions.Plugins.roomVersion}"
        const val roomCompiler = "androidx.room:room-compiler:${Versions.Plugins.roomVersion}"
    }

    object Layout {
        /* constraintlayout */
        const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.Plugins.constraintLayout}"

        // swipe-to-refresh
        // 스와이프 하여 새로고침
        // https://developer.android.com/jetpack/androidx/releases/swiperefreshlayout
        const val swipe = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.Plugins.swipeVersion}"
    }

    // easy permission
    object Permission {
        const val easyPermission = "pub.devrel:easypermissions:${Versions.Plugins.easyPermissionVersion}"
    }

    // google
    object Google {
        const val material = "com.google.android.material:material:${Versions.Plugins.materialVersion}"
        // gson
        const val gson = "com.google.code.gson:gson:${Versions.Plugins.gson}"
    }

    // tikxml
    // xml 데이터를 파싱하기 위한 라이브러리
    // https://github.com/Tickaroo/tikxml
    object Tikxml {
        const val annotation = "com.tickaroo.tikxml:annotation:${Versions.Plugins.tikxmlVersion}"
        const val core = "com.tickaroo.tikxml:core:${Versions.Plugins.tikxmlVersion}"
        const val retrofitConverter = "com.tickaroo.tikxml:retrofit-converter:${Versions.Plugins.tikxmlVersion}"
        const val processor = "com.tickaroo.tikxml:processor:${Versions.Plugins.tikxmlVersion}"
        const val autoValue = "com.tickaroo.tikxml:auto-value-tikxml:${Versions.Plugins.tikxmlVersion}"
    }

    // jsoup
    // og graph tag를 파싱하기위해 사용
    // https://github.com/jhy/jsoup
    object Jsoup {
        const val jsoup = "org.jsoup:jsoup:${Versions.Plugins.jsoupVersion}"
    }

    // glide
    // 이미지 로드와 다양한 옵션을 설정하기 위해 사용한 라이브러리
    // https://github.com/bumptech/glide
    object Glide {
        const val glide = "com.github.bumptech.glide:glide:${Versions.Plugins.glideVersion}"
        const val compiler = "com.github.bumptech.glide:compiler:${Versions.Plugins.glideVersion}"
    }

    // okhttp3
    // retrofit과 같이 사용하여 로그와 인터넷 통신에 여러 옵션을 설정하기 위한 라이브러리
    // https://github.com/square/okhttp
    object Okhttp {
        const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.Plugins.okhttpVersion}"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.Plugins.okhttpLoggingVersion}"
    }

    // retrofit2
    // 인터넷 통신을 위해 사용한 라이브러리
    // https://github.com/square/retrofit
    object Retrofit2 {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.Plugins.retrofitVersion}"
        const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.Plugins.converterGsonVersion}"
        const val adapterRxjava = "com.squareup.retrofit2:adapter-rxjava3:${Versions.Plugins.adapterRxjavaVersion}"
    }

    // threetenbp
    // java에 내장되어 있는 시간 관련 클래스들 보다 뛰어난 시간 관련 라이브러리
    // https://github.com/JakeWharton/ThreeTenABP
    object Threetenbp {
        const val threetenbp = "com.jakewharton.threetenabp:threetenabp:${Versions.Plugins.threetenbpVersion}"
    }

    // rxjava
    // 안드로이드에서 Rx 프로그래밍을 할 수 있도록 해주는 라이브러리
    // rx android : https://github.com/ReactiveX/RxAndroid
    // rx java : https://github.com/ReactiveX/RxJava
    // rx kotlin : https://github.com/ReactiveX/RxKotlin
    // rx binding : https://github.com/JakeWharton/RxBinding
    object Rx {
        const val java = "io.reactivex.rxjava3:rxjava:${Versions.Plugins.rxjavaVersion}"
        const val android = "io.reactivex.rxjava3:rxandroid:${Versions.Plugins.rxandroidVersion}"
        const val kotlin = "io.reactivex.rxjava3:rxkotlin:${Versions.Plugins.rxkotlinVersion}"
        const val binding = "com.jakewharton.rxbinding4:rxbinding:${Versions.Plugins.rxbindingBersion}"
    }

    object Hilt {
        const val hilt = "com.google.dagger:hilt-android-gradle-plugin:${Versions.Plugins.hiltVersion}"
        const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.Plugins.hiltVersion}"
        const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.Plugins.hiltVersion}"
    }

    object KotlinSerialization {
        const val kotlinSerialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.Plugins.kotlinxSerialization}"
        const val kotlinSerializationConverter = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.Plugins.serializationConverter}"
        const val kotlinSerializationCore = "org.jetbrains.kotlinx:kotlinx-serialization-core:${Versions.Plugins.kotlinxSerialization}" // JVM dependency
    }

    object Test {
        const val junit = "junit:junit:${Versions.Plugins.junit}"
        const val junitExt = "androidx.test.ext:junit:${Versions.Plugins.junitExt}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.Plugins.espressoCore}"
    }
}
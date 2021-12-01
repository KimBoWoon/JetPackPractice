// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(com.bowoon.android.buildsrc.Dependencies.Kotlin.gradle)
        classpath(com.bowoon.android.buildsrc.Dependencies.Kotlin.plugin)
        classpath(com.bowoon.android.buildsrc.Dependencies.Hilt.hilt)
        classpath(com.bowoon.android.buildsrc.Dependencies.Ktx.safeArgument)
        classpath(com.bowoon.android.buildsrc.Dependencies.Kotlin.serialization)
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts files
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

task("clean", Delete::class) {
    delete = setOf(rootProject.buildDir)
}
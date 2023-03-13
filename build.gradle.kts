// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Dependencies.Kotlin.gradle)
//        classpath(Dependencies.Kotlin.plugin)
        classpath(Dependencies.Hilt.hilt)
        classpath(Dependencies.Ktx.safeArgument)
//        classpath(Dependencies.Kotlin.serialization)
        classpath(kotlin("gradle-plugin", version = Versions.Plugins.kotlin))
        classpath(kotlin("serialization", version = Versions.Plugins.kotlin))
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts files
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven { setUrl("https://jitpack.io") }
    }
}

task("clean", Delete::class) {
    delete = setOf(rootProject.buildDir)
}
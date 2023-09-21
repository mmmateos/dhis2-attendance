pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")

        buildscript {
            repositories {
                google()
                gradlePluginPortal()
                mavenCentral()
                maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
                maven {
                    // r8 maven
                    url = uri("https://storage.googleapis.com/r8-releases/raw")
                }
            }
            dependencies {
                classpath("com.android.tools:r8:8.2.24")
            }
        }
    }

    plugins {
        kotlin("multiplatform").version(extra["kotlin.version"] as String)
        kotlin("android").version(extra["kotlin.version"] as String)
        id("com.android.application").version(extra["agp.version"] as String)
        id("com.android.library").version(extra["agp.version"] as String)
        id("org.jetbrains.compose").version(extra["compose.version"] as String)
    }
}

rootProject.name = "attendance"

include(":android", ":desktop", ":common")

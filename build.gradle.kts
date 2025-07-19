// AdminApp/build.gradle.kts

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    id("com.google.gms.google-services") version "4.4.1" apply false
    id("com.google.dagger.hilt.android") version "2.48" apply false
}
buildscript {
    dependencies {
        classpath("com.google.gms:google-services:4.4.0") // ✅ latest version
    }
}

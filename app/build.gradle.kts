plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    id("kotlin-parcelize")
}

android {
    namespace = "com.test.challenge.toyotaapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.test.challenge.toyotaapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.ui.test.junit4)
    androidTestImplementation(libs.daggerHiltAndroidTesting)
    androidTestImplementation(libs.hilt.android.testing)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    api(libs.jetbrains.kotlinx.coroutines.android)
    api(libs.kotlinxCoroutines)
    debugImplementation(libs.androidx.ui.test.manifest)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidxComposeUiTestManifest)
    debugImplementation(libs.androidxComposeUiTooling)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidxActivity)
    implementation(libs.androidxCore)
    implementation(libs.androidxLifecycle)
    implementation(libs.coilCompose)
    implementation(libs.constraintlayoutCompose)
    implementation(libs.daggerHilt)
    implementation(libs.hiltNavigationCompose)
    implementation(libs.logging.interceptor)
    implementation(libs.okhttp)
    implementation(libs.okhttpLoggingInterceptor)
    implementation(libs.retrofit)
    implementation(libs.retrofit2.converter.gson)
    implementation(libs.retrofitConverterGson)
    implementation(platform(libs.androidx.compose.bom))
    kapt(libs.daggerHiltCompiler)
    kapt(libs.hilt.compiler)
    kaptAndroidTest(libs.daggerHiltCompiler)
    kaptAndroidTest(libs.hilt.compiler)
    kaptTest(libs.daggerHiltCompiler)
    kaptTest(libs.hilt.compiler)
    testImplementation(libs.daggerHiltAndroidTesting)
    testImplementation(libs.hilt.android.testing)
    testImplementation(libs.junit)
    implementation (libs.material3)
}
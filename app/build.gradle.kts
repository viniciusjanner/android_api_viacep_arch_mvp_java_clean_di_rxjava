plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.google.dagger.hilt)
}

android {
    namespace = "com.viniciusjanner.apiviacep"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.viniciusjanner.apiviacep"
        minSdk = 21
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        multiDexEnabled = true

        buildConfigField("String", "BASE_URL", "\"https://viacep.com.br/ws/\"")
    }

    buildFeatures {
        buildConfig = true
        viewBinding = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            // Usa a configuração de assinatura de debug padrão
            signingConfig = signingConfigs.getByName("debug")
        }

        getByName("debug") {
            isDebuggable = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    // AndroidX
    implementation(libs.androidx.activity)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.coreKtx)
    implementation(libs.androidx.coreSplashScreen)
    implementation(libs.androidx.fragmentKtx)
    implementation(libs.androidx.lifecycle.livedataKtx)
    implementation(libs.androidx.lifecycle.viewmodelKtx)
    implementation(libs.androidx.multidex)

    // Google
    implementation(libs.google.material)

    // Squareup
    implementation(libs.squareup.okhttp3.loggingInterceptor)
    implementation(libs.squareup.okhttp3.okhttp)
    implementation(platform(libs.squareup.okhttp3.okhttp3))
    implementation(libs.squareup.retrofit2.adapterRxjava3)
    implementation(libs.squareup.retrofit2.converterGson)
    implementation(libs.squareup.retrofit2.retrofit)

    // RxJava
    implementation(libs.rxjava3.rxjava)
    implementation(libs.rxjava3.rxandroid)

    // Dagger 2
    implementation(libs.google.dagger)
    annotationProcessor(libs.google.dagger.compiler)

    // Dagger Hilt
    implementation(libs.google.dagger.hilt.android)
    annotationProcessor(libs.google.dagger.hilt.compiler)

    // Koin
    implementation(libs.koin.android)
    implementation(libs.koin.core)
}

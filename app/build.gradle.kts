plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "kz.zhandos.weatherandroid"
    compileSdk = 33

    defaultConfig {
        applicationId = "kz.zhandos.weatherandroid"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
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
        viewBinding = true
    }
}

dependencies {
    implementation(project(path = ":lib:core"))
    implementation(project(path = ":lib:coreUI"))
    implementation(project(path = ":lib:coreData"))
    implementation(project(path = ":lib:navigation"))

    implementation(project(path = ":features:weather"))

    implementation(libs.bundles.androidx)
    implementation(libs.bundles.di)
    implementation(libs.cicerone)


    debugImplementation("com.github.chuckerteam.chucker:library:3.5.2")
    releaseImplementation("com.github.chuckerteam.chucker:library-no-op:3.5.2")
}
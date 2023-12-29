@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    alias(libs.plugins.sql.delight.gradle.plugin)
}

android {
    namespace = "ru.foolstack.storage"
    compileSdk = 34

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        kotlinCompilerExtensionVersion = "1.4.3"
    }
}

sqldelight {
    databases {
        create("Database") {
            packageName.set("ru.foolstack")
        }
    }
}

dependencies {
    implementation(libs.activity.compose)
    implementation(libs.core.ktx)
    implementation(platform(libs.compose.bom))
    implementation(libs.appcompat)
    implementation(libs.compose.vm)
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.koin.android)
    implementation(libs.koin.compose)
    implementation(libs.sql.delight.android.driver)
    implementation(libs.sql.delight.coroutines.ext)
    implementation(libs.androidx.foundation.layout.android)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
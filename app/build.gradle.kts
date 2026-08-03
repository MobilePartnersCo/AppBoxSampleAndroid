plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "kr.co.mobpa.appbox.sdkSample"
    compileSdk = 36

    defaultConfig {
        applicationId = "kr.co.mobpa.appbox.sdkSample"
        minSdk = 26
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            // AppBox artifact 는 각자 consumer 규칙을 함께 배포하므로 축소·난독화를 켠 상태가
            // 기본 구성입니다. 이 값을 false 로 두면 R8 이 도는 경로를 한 번도 확인하지 못한
            // 채 배포하게 됩니다.
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        // AppBox SDK가 JVM 17로 컴파일되어 있어 소비 앱도 17이 필요합니다.
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // --------------------------------------------------------------
    // AppBox SDK
    //
    // BOM으로 버전을 맞추고 사용할 기능의 artifact만 추가합니다.
    // appbox-core 는 모든 구성에서 반드시 선언해야 합니다.
    // --------------------------------------------------------------
    implementation(platform("com.appboxapp.sdk:appbox-bom:1.3.36"))

    implementation("com.appboxapp.sdk:appbox-core")      // 필수
    implementation("com.appboxapp.sdk:appbox-webview")   // AppBox 관리 화면
    implementation("com.appboxapp.sdk:appbox-push")      // 푸시 알림

    // 필요할 때 아래 artifact 를 추가로 선언합니다.
    // implementation("com.appboxapp.sdk:appbox-inapp")         // 네이티브 인앱 메시지
    // implementation("com.appboxapp.sdk:appbox-health")        // 걸음 수
    // implementation("com.appboxapp.sdk:appbox-appsflyer")     // AppsFlyer 딥링크
    // implementation("com.appboxapp.sdk:appbox-auth-google")   // Google 로그인
    // implementation("com.appboxapp.sdk:appbox-auth-apple")    // Apple 로그인
    // implementation("com.appboxapp.sdk:appbox-auth-naver")    // Naver 로그인
    // implementation("com.appboxapp.sdk:appbox-auth-kakao")    // Kakao 로그인
    // --------------------------------------------------------------
}
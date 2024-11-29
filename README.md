
# AppBox SDK

AppBox SDK는 안드로이드 애플리케이션에서 다양한 기능을 초기화하고 실행할 수 있는 도구를 제공합니다. 이 문서에서는 설치 방법과 주요 기능에 대해 설명합니다.

---

## SDK 주요 기능

- **SDK 초기화**
- **인트로 관리**
- **푸시 토큰 관리**
- **푸시 아이콘 관리**
- **당겨서 새로고침 관리**
- **SDK 실행**

---

## 설치 방법

AppBox SDK는 [JitPack](https://jitpack.io) 저장소를 통해 제공됩니다. 아래 단계를 따라 프로젝트에 SDK를 통합하세요.

### Gradle 설정

#### 1. 프로젝트 수준의 `build.gradle` 파일 수정

프로젝트의 `build.gradle` 파일에 JitPack 저장소를 추가합니다.

```gradle
repositories {
    google()
    mavenCentral()
    maven {
        url = uri("https://jitpack.io")
        // --------------------------------------------------------------
        // SDK 접근 설정
        // --------------------------------------------------------------
        credentials {
            username = "jp_gv49u3alugbbocfovlkfnvdt8a"
        }
        // --------------------------------------------------------------
    }
}
```

#### 2. 앱 수준의 `build.gradle` 파일에 SDK 의존성 추가

아래 의존성을 추가합니다:

```gradle
dependencies {
    // --------------------------------------------------------------
    // implementation 선언
    // --------------------------------------------------------------
    implementation("org.bitbucket.insystems_moon:appboxpackage:1.0.21")
    implementation("androidx.biometric:biometric-ktx:1.2.0-alpha05")
    implementation("com.journeyapps:zxing-android-embedded:4.3.0")
    implementation("com.google.zxing:core:3.4.1")
    implementation("com.google.android.play:app-update-ktx:2.1.0")
    implementation("com.github.bumptech.glide:glide:4.16.0")
    implementation("com.github.chrisbanes:PhotoView:2.3.0")
    implementation("androidx.health.connect:connect-client:1.1.0-alpha07")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation("com.github.prolificinteractive:material-calendarview:2.0.1")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    // --------------------------------------------------------------
}
```

#### 3. `gradle.properties`에 Jetifier 활성화

Jetifier를 활성화하려면 `gradle.properties` 파일에 다음 설정을 추가합니다:

```gradle
# --------------------------------------------------------------
# enableJetifier 설정
# --------------------------------------------------------------
android.enableJetifier=true
# --------------------------------------------------------------
```

---

## 사용법

### 1. SDK 초기화

AppBox SDK를 사용하려면 먼저 초기화를 수행해야 합니다. `initSDK` 메서드를 호출하여 초기화를 완료하세요.

#### 예제 코드:

```kotlin
// --------------------------------------------------------------
// AppBox WebConfig 설정
// --------------------------------------------------------------
val appBoxWebConfig = AppBoxWebConfig().apply {
    javaScriptEnabled = true
}
// --------------------------------------------------------------

// --------------------------------------------------------------
// AppBox 초기화
// --------------------------------------------------------------
AppBox.getInstance().initSDK(
    context = this,
    baseUrl = "https://www.example.com",
    debugMode = true,
    webConfig = appBoxWebConfig
)
// --------------------------------------------------------------
```

---

### 2. SDK 실행

초기화된 SDK를 실행하려면 `start` 메서드를 호출하세요. 실행 결과는 콜백을 통해 전달됩니다.

#### 예제 코드:

```kotlin
// --------------------------------------------------------------
// AppBox 실행
// --------------------------------------------------------------
AppBox.getInstance().start { isSuccess, message ->
    if (isSuccess) {
        // 실행 성공 처리
        Log.d("AppBox", "SDK 실행 성공")
    } else {
        // 실행 실패 처리
        Log.e("AppBox", "SDK 실행 실패: $message")
    }
}
// --------------------------------------------------------------
```

---

### 3. 추가 기능 설정

#### 푸시 토큰 설정

```kotlin
// --------------------------------------------------------------
// AppBox 푸시 토큰 설정
// --------------------------------------------------------------
AppBox.getInstance().setPushToken(
    token = "푸시 토큰 값"
)
// --------------------------------------------------------------
```

#### 푸시 아이콘 설정

```kotlin
// --------------------------------------------------------------
// AppBox 푸시 아이콘 설정
// --------------------------------------------------------------
AppBox.getInstance().setPushIcon(
    icon = R.drawable.ic_launcher_background
)
// --------------------------------------------------------------
```

#### 인트로 설정

```kotlin
// --------------------------------------------------------------
// 인트로 설정
// --------------------------------------------------------------
AppBox.getInstance().setIntro(
    items = mutableListOf("https://www.example1.com", "https://www.example2.com")
)
// --------------------------------------------------------------
```

#### 당겨서 새로고침 설정

```kotlin
// --------------------------------------------------------------
// 당겨서 새로고침 설정
// --------------------------------------------------------------
AppBox.getInstance().setPullDownRefresh(
    used = true
)
// --------------------------------------------------------------
```

---

## 요구 사항

- **Android** 8.0 이상
- **Gradle Version** 8.7

---

## 주의 사항

1. **초기화 필수**
   - `initSDK`를 호출하여 SDK를 초기화한 후에만 다른 기능을 사용할 수 있습니다.
   - 초기화를 수행하지 않으면 실행 시 예외가 발생할 수 있습니다.

2. **네트워크 권한**
   - SDK는 네트워크 권한이 필요합니다. `AndroidManifest.xml` 파일에 다음 권한을 추가하세요:

     ```xml
     <uses-permission android:name="android.permission.INTERNET" />
     ```

---

## 지원

문제가 발생하거나 추가 지원이 필요한 경우 아래로 연락하세요:

- **이메일**: [contact@mobpa.co.kr](mailto:contact@mobpa.co.kr)
- **홈페이지**: [https://www.appboxapp.com](https://www.appboxapp.com)

---

## 라이선스

- 앱박스의 SDK의 사용은 영구적으로 무료입니다. 기업 또는 개인 상업적인 목적으로 사용 할 수 있습니다.
- 앱박스는 웹사이트를 자바스크립트 코드를 사용해서 앱의 기능을 사용할 수 있게 하는 솔루션입니다.

---

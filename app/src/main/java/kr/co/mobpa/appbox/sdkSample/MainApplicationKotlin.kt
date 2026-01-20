package kr.co.mobpa.appbox.sdkSample

import android.app.Application
import kr.co.mobpa.waveAppSuiteSdk.AppBox
import kr.co.mobpa.waveAppSuiteSdk.data.AppBoxWebConfig

class MainApplicationKotlin : Application() {
    override fun onCreate() {
        super.onCreate()

        // --------------------------------------------------------------
        // AppBox AppBoxWebConfig 설정
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
            projectId = "PROJECT_ID",
            webConfig = appBoxWebConfig,
            debugMode = true,
            pushIcon = R.drawable.ic_launcher_background,
            kakaoNativeAppKey = "",
            naverClientId = "",
            naverSecret = "",
            googleClientId = ""
        )
        // --------------------------------------------------------------
    }
}
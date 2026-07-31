package kr.co.mobpa.appbox.sdkSample

import android.app.Application
import android.util.Log
import kr.co.mobpa.appbox.core.AppBox
import kr.co.mobpa.appbox.core.AppBoxCommonConfig
import kr.co.mobpa.appbox.core.AppBoxInitConfig
import kr.co.mobpa.appbox.core.AppBoxInitStatus
import kr.co.mobpa.appbox.core.AppBoxPushConfig
import kr.co.mobpa.appbox.core.AppBoxUsageMode
import kr.co.mobpa.appbox.core.AppBoxWebViewConfig

class MainApplicationKotlin : Application() {
    override fun onCreate() {
        super.onCreate()

        // --------------------------------------------------------------
        // AppBox 초기화
        //
        // Application.onCreate() 에서 한 번만 호출합니다.
        // 값을 즉시 반환하며 기능별 초기화 상태를 각각 담고 있습니다.
        // --------------------------------------------------------------
        val result = AppBox.initialize(
            context = this,
            config = AppBoxInitConfig(
                // AppBox 관리 화면이 앱의 주 화면이므로 푸시 클릭도 이 화면으로 보냅니다.
                usageMode = AppBoxUsageMode.APPBOX_WEBVIEW,
                common = AppBoxCommonConfig(
                    projectId = "PROJECT_ID",
                    pushIcon = R.drawable.ic_launcher_background,
                    debugMode = true
                ),
                webView = AppBoxWebViewConfig(
                    baseUrl = "https://www.example.com"
                ),
                push = AppBoxPushConfig()
            )
        )
        // --------------------------------------------------------------

        // --------------------------------------------------------------
        // 초기화 결과 확인
        //
        // 한 기능의 실패가 다른 기능을 막지 않으므로 사용할 기능을 각각 확인합니다.
        // --------------------------------------------------------------
        if (result.core.status != AppBoxInitStatus.INITIALIZED) {
            Log.w("AppBoxKotlin", "core: " + (result.core.error?.message ?: result.core.message))
        }
        if (result.webView.status != AppBoxInitStatus.INITIALIZED) {
            Log.w("AppBoxKotlin", "webView: " + (result.webView.error?.message ?: result.webView.message))
        }
        if (result.push.status != AppBoxInitStatus.INITIALIZED) {
            Log.w("AppBoxKotlin", "push: " + (result.push.error?.message ?: result.push.message))
        }
        // --------------------------------------------------------------
    }
}

package kr.co.mobpa.appbox.sdkSample

import android.app.Application
import android.content.Context
import android.util.Log
import kr.co.mobpa.appbox.core.AppBox
import kr.co.mobpa.appbox.core.AppBoxCommonConfig
import kr.co.mobpa.appbox.core.AppBoxInitConfig
import kr.co.mobpa.appbox.core.AppBoxInitStatus
import kr.co.mobpa.appbox.core.AppBoxPushConfig
import kr.co.mobpa.appbox.core.AppBoxUsageMode
import kr.co.mobpa.appbox.core.AppBoxWebViewConfig
import kr.co.mobpa.appbox.core.push.PushEventListener
import kr.co.mobpa.appbox.core.push.PushEventPayload

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
                    // 프로젝트 ID 와 웹 주소는 SampleConfig 한 곳에서 관리합니다.
                    projectId = SampleConfig.PROJECT_ID,
                    // 알림 small icon 은 실루엣으로 마스킹되므로 흰색/투명 전용 리소스를 씁니다.
                    // 런처 아이콘을 넣으면 단색 사각형으로 보입니다.
                    pushIcon = R.drawable.ic_notification,
                    debugMode = true
                ),
                webView = AppBoxWebViewConfig(
                    baseUrl = SampleConfig.BASE_URL
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

        // --------------------------------------------------------------
        // 푸시 클릭 처리
        //
        // 알림 권한 요청과 알림 표시는 SDK 가 처리합니다.
        // 사용자가 알림을 클릭했을 때 무엇을 할지는 앱이 정합니다.
        //
        // listener 는 하나만 유지되며 다시 호출하면 교체됩니다.
        // null 을 전달하면 등록을 해제합니다.
        // --------------------------------------------------------------
        AppBox.setPushEventListener(object : PushEventListener {
            override fun onPushClicked(context: Context, payload: PushEventPayload) {
                Log.d(
                    "AppBoxKotlin",
                    "푸시 클릭: title=${payload.title}, param=${payload.param}, paramType=${payload.paramType}"
                )

                // 여기서 payload.param 을 보고 원하는 화면으로 이동시킵니다.
            }
        })
        // --------------------------------------------------------------
    }
}

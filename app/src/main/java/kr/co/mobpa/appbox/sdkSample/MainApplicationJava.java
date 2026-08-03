package kr.co.mobpa.appbox.sdkSample;

import android.app.Application;
import android.util.Log;

import kr.co.mobpa.appbox.core.AppBox;
import kr.co.mobpa.appbox.core.AppBoxCommonConfig;
import kr.co.mobpa.appbox.core.AppBoxInitConfig;
import kr.co.mobpa.appbox.core.AppBoxInitResult;
import kr.co.mobpa.appbox.core.AppBoxInitStatus;
import kr.co.mobpa.appbox.core.AppBoxModuleInitResult;
import kr.co.mobpa.appbox.core.AppBoxPushConfig;
import kr.co.mobpa.appbox.core.AppBoxUsageMode;
import kr.co.mobpa.appbox.core.AppBoxWebViewConfig;

public class MainApplicationJava extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // --------------------------------------------------------------
        // AppBox 초기화
        //
        // Java 에서는 각 설정 클래스의 Builder 를 사용합니다.
        // Application.onCreate() 에서 한 번만 호출합니다.
        // --------------------------------------------------------------
        AppBoxInitConfig config = new AppBoxInitConfig.Builder()
                // AppBox 관리 화면이 앱의 주 화면이므로 푸시 클릭도 이 화면으로 보냅니다.
                .setUsageMode(AppBoxUsageMode.APPBOX_WEBVIEW)
                .setCommon(new AppBoxCommonConfig.Builder()
                        // 프로젝트 ID 와 웹 주소는 SampleConfig 한 곳에서 관리합니다.
                        .setProjectId(SampleConfig.PROJECT_ID)
                        // 알림 small icon 은 실루엣으로 마스킹되므로 흰색/투명 전용 리소스를 씁니다.
                        // 런처 아이콘을 넣으면 단색 사각형으로 보입니다.
                        .setPushIcon(R.drawable.ic_notification)
                        .setDebugMode(true)
                        .build())
                .setWebView(new AppBoxWebViewConfig.Builder()
                        .setBaseUrl(SampleConfig.BASE_URL)
                        .build())
                .setPush(new AppBoxPushConfig.Builder().build())
                .build();

        AppBoxInitResult result = AppBox.initialize(this, config);
        // --------------------------------------------------------------

        // --------------------------------------------------------------
        // 초기화 결과 확인
        //
        // 한 기능의 실패가 다른 기능을 막지 않으므로 사용할 기능을 각각 확인합니다.
        // --------------------------------------------------------------
        logIfNotInitialized("core", result.getCore());
        logIfNotInitialized("webView", result.getWebView());
        logIfNotInitialized("push", result.getPush());
        // --------------------------------------------------------------
    }

    private void logIfNotInitialized(String name, AppBoxModuleInitResult moduleResult) {
        if (moduleResult.getStatus() == AppBoxInitStatus.INITIALIZED) {
            return;
        }
        Throwable error = moduleResult.getError();
        String message = error != null ? error.getMessage() : moduleResult.getMessage();
        Log.w("AppBoxJava", name + ": " + message);
    }
}

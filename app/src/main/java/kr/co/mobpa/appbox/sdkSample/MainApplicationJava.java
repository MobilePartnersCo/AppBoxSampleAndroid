package kr.co.mobpa.appbox.sdkSample;

import android.app.Application;

import kr.co.mobpa.waveAppSuiteSdk.AppBox;
import kr.co.mobpa.waveAppSuiteSdk.data.AppBoxWebConfig;

public class MainApplicationJava extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // --------------------------------------------------------------
        // AppBox AppBoxWebConfig 설정
        // --------------------------------------------------------------
        AppBoxWebConfig appBoxWebConfig = new AppBoxWebConfig();
        appBoxWebConfig.setJavaScriptEnabled(true);
        // --------------------------------------------------------------

        // --------------------------------------------------------------
        // AppBox 초기화
        // --------------------------------------------------------------
        AppBox.getInstance().initSDK(
                this,
                "https://www.example.com",
                "프로젝트 아이디",
                true,
                appBoxWebConfig,
                R.drawable.ic_launcher_background
        );
        // --------------------------------------------------------------
    }
}

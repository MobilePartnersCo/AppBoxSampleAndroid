package kr.co.mobpa.appbox.sdkSample;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kr.co.mobpa.waveAppSuiteSdk.AppBox;
import kr.co.mobpa.waveAppSuiteSdk.data.AppBoxWebConfig;

public class MainActivityJava extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // --------------------------------------------------------------
        // AppBox WebConfig 설정
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
                true,
                appBoxWebConfig
        );
        // --------------------------------------------------------------

        // --------------------------------------------------------------
        // AppBox 푸시 토큰 설정
        // --------------------------------------------------------------
        AppBox.getInstance().setPushToken("푸시 토큰 값");
        // --------------------------------------------------------------

        // --------------------------------------------------------------
        // AppBox 푸시 아이콘 설정
        // --------------------------------------------------------------
        AppBox.getInstance().setPushIcon(R.drawable.ic_launcher_background);
        // --------------------------------------------------------------

        // --------------------------------------------------------------
        // 인트로 설정
        // --------------------------------------------------------------
        List<String> introItems = new ArrayList<>();
        introItems.add("https://www.example1.com");
        introItems.add("https://www.example2.com");
        AppBox.getInstance().setIntro(introItems);
        // --------------------------------------------------------------

        // --------------------------------------------------------------
        // 당겨서 새로고침 설정
        // --------------------------------------------------------------
        AppBox.getInstance().setPullDownRefresh(true);
        // --------------------------------------------------------------

        // --------------------------------------------------------------
        // AppBox 실행
        // --------------------------------------------------------------
        AppBox.getInstance().start((isSuccess, message) -> {
            if (isSuccess) {
                // 실행 성공 처리
                Log.d("AppBox", "SDK 실행 성공");
            } else {
                // 실행 실패 처리
                Log.e("AppBox", "SDK 실행 실패: " + message);
            }
            return null;
        });
        // --------------------------------------------------------------

    }

}

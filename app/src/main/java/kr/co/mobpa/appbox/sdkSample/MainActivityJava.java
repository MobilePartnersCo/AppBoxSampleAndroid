package kr.co.mobpa.appbox.sdkSample;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import kr.co.mobpa.waveAppSuiteSdk.AppBox;
import kr.co.mobpa.waveAppSuiteSdk.data.AppBoxIntro;
import kr.co.mobpa.waveAppSuiteSdk.data.AppBoxIntroItems;

public class MainActivityJava extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // --------------------------------------------------------------
        // AppBox URL 변경
        // --------------------------------------------------------------
        AppBox.getInstance().setBaseUrl("https://www.example.com");
        // --------------------------------------------------------------

        // --------------------------------------------------------------
        // AppBox 디버그 변경
        // --------------------------------------------------------------
        AppBox.getInstance().setDebug(true);
        // --------------------------------------------------------------

        // --------------------------------------------------------------
        // AppBox AppBoxIntro 설정
        // --------------------------------------------------------------
        List<AppBoxIntroItems> introList = new ArrayList<>();
        introList.add(new AppBoxIntroItems("https://www.example1.com"));
        introList.add(new AppBoxIntroItems("https://www.example2.com"));
        introList.add(new AppBoxIntroItems("https://www.example3.com"));
        introList.add(new AppBoxIntroItems("https://www.example4.com"));
        AppBoxIntro appBoxIntro = new AppBoxIntro(introList);
        // --------------------------------------------------------------

        // --------------------------------------------------------------
        // AppBox 인트로 설정
        // --------------------------------------------------------------
        AppBox.getInstance().setIntro(appBoxIntro);
        // --------------------------------------------------------------

        // --------------------------------------------------------------
        // AppBox 당겨서 새로고침 설정
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

package kr.co.mobpa.appbox.sdkSample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kr.co.mobpa.waveAppSuiteSdk.AppBox
import kr.co.mobpa.waveAppSuiteSdk.data.AppBoxIntro
import kr.co.mobpa.waveAppSuiteSdk.data.AppBoxIntroItems

class MainActivityKotlin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // --------------------------------------------------------------
        // AppBox URL 변경
        // --------------------------------------------------------------
        AppBox.getInstance().setBaseUrl(
            baseUrl = "https://www.example.com"
        )
        // --------------------------------------------------------------

        // --------------------------------------------------------------
        // AppBox 디버그 변경
        // --------------------------------------------------------------
        AppBox.getInstance().setDebug(
            debugMode = true
        )
        // --------------------------------------------------------------

        // --------------------------------------------------------------
        // AppBox AppBoxIntro 설정
        // --------------------------------------------------------------
        val appBoxIntro = AppBoxIntro(
            indicatorDefColor = "#FF0000",
            indicatorSelColor = "#00FF00",
            fontColor = "#0000FF",
            item = mutableListOf(
                AppBoxIntroItems(imageUrl =  "https://www.example1.com"),
                AppBoxIntroItems(imageUrl =  "https://www.example2.com"),
                AppBoxIntroItems(imageUrl =  "https://www.example3.com"),
                AppBoxIntroItems(imageUrl =  "https://www.example4.com")
            )
        )
        // --------------------------------------------------------------

        // --------------------------------------------------------------
        // AppBox 인트로 설정
        // --------------------------------------------------------------
        AppBox.getInstance().setIntro(
            appBoxIntro = appBoxIntro
        )
        // --------------------------------------------------------------

        // --------------------------------------------------------------
        // AppBox 당겨서 새로고침 설정
        // --------------------------------------------------------------
        AppBox.getInstance().setPullDownRefresh(
            used = true
        )
        // --------------------------------------------------------------

        // --------------------------------------------------------------
        // AppBox 실행
        // --------------------------------------------------------------
        AppBox.getInstance().start { isSuccess, message ->
            if (isSuccess) {
                // 실행 성공 처리
                Log.d("AppBoxKotlin", "SDK 실행 성공")
            } else {
                // 실행 실패 처리
                Log.e("AppBoxKotlin", "SDK 실행 실패: $message")
            }
        }
        // --------------------------------------------------------------

    }
}
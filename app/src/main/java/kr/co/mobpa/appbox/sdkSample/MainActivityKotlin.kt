package kr.co.mobpa.appbox.sdkSample

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kr.co.mobpa.waveAppSuiteSdk.AppBox
import kr.co.mobpa.waveAppSuiteSdk.data.AppBoxWebConfig

class MainActivityKotlin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

        // --------------------------------------------------------------
        // AppBox 푸시 토큰 설정
        // --------------------------------------------------------------
        AppBox.getInstance().setPushToken(
            token = "푸시 토큰 값"
        )
        // --------------------------------------------------------------

        // --------------------------------------------------------------
        // AppBox 푸시 아이콘 설정
        // --------------------------------------------------------------
        AppBox.getInstance().setPushIcon(
            icon = R.drawable.ic_launcher_background
        )
        // --------------------------------------------------------------

        // --------------------------------------------------------------
        // 인트로 설정
        // --------------------------------------------------------------
        AppBox.getInstance().setIntro(
            items = mutableListOf("https://www.example1.com", "https://www.example2.com")
        )
        // --------------------------------------------------------------

        // --------------------------------------------------------------
        // 당겨서 새로고침 설정
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
                Log.d("AppBox", "SDK 실행 성공")
            } else {
                // 실행 실패 처리
                Log.e("AppBox", "SDK 실행 실패: $message")
            }
        }
        // --------------------------------------------------------------

    }
}
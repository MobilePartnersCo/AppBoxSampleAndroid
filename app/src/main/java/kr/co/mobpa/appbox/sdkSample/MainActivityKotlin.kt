package kr.co.mobpa.appbox.sdkSample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kr.co.mobpa.appbox.core.AppBox
import kr.co.mobpa.appbox.core.AppBoxSystemBarStyle

class MainActivityKotlin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // --------------------------------------------------------------
        // AppBox 로딩 화면 설정
        //
        // 인자를 줄인 형태도 제공합니다. setLoadingData() 만 호출하면 기본값을 씁니다.
        // --------------------------------------------------------------
        AppBox.setLoadingData(
            loadingIcon = null,
            sizePercentage = 10f,
            iconColor = null,
            backColor = null
        )
        // --------------------------------------------------------------

        // --------------------------------------------------------------
        // AppBox 시스템 바 외관 설정
        //
        // style 은 글자와 아이콘 기준입니다.
        // Light 는 밝은(흰색) 글자, Dark 는 어두운(검은색) 글자입니다.
        // 잘못된 색상값을 전달하면 호출 전체가 무시됩니다.
        // --------------------------------------------------------------
        AppBox.setSystemBarAppearance(
            backgroundHex = "#FFFFFF",
            style = AppBoxSystemBarStyle.Dark
        )
        // --------------------------------------------------------------

        // --------------------------------------------------------------
        // AppBox 당겨서 새로고침 설정
        // --------------------------------------------------------------
        AppBox.setPullDownRefresh(
            used = true
        )
        // --------------------------------------------------------------

        // --------------------------------------------------------------
        // AppBox 실행
        //
        // success 는 화면 실행 요청이 전달됐다는 의미이며
        // 웹페이지 로딩 완료를 뜻하지 않습니다.
        //
        // onCreate 는 화면 회전이나 프로세스 복귀로 다시 호출되므로
        // savedInstanceState 가 null 인 최초 진입에서만 실행합니다.
        // --------------------------------------------------------------
        if (savedInstanceState == null) {
            AppBox.start { success, error ->
                if (success) {
                    Log.d("AppBoxKotlin", "SDK 실행 성공")
                } else {
                    Log.e("AppBoxKotlin", "SDK 실행 실패: ${error?.message}")
                }
            }
        }
        // --------------------------------------------------------------
    }
}

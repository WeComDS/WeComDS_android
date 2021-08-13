package com.example.wsw

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {


    // 액티비티가 프래그먼트를 멤버 변수화 해서 관리하겠다. 메모리 단위
    private val fragmentHome = HomeFragment()
    private val fragmentSecretBoard = SecretBoardFragment()
    private val fragmentReviewBoard = ReviewBoardFragment()
    private val fragmentStudyBoard = StudyBoardFragment()
    private val fragmentQuestionBoard = QuestionBoardFragment()

    //  리스트 형식으로 정리
    private val fragments = mapOf(
            R.id.frag_navigation_home to fragmentHome,
            R.id.frag_navigation_secret to fragmentSecretBoard,
            R.id.frag_navigation_study to fragmentStudyBoard,
            R.id.frag_navigation_review to fragmentReviewBoard,
            R.id.frag_navigation_question to fragmentQuestionBoard
    )

    // active는 현재 보여지는 화면
    private lateinit var active: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 바텀 네비게이션 화면 전환
        //.setOnNavigationItemSelectedListener(this)
        //ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), 1)

        //bottom_nav.selectedItemId = R.id.menu_home

        val navView: BottomNavigationView = findViewById(R.id.bottom_nav)
        navView.setOnNavigationItemSelectedListener(this)

        //for each문은 자동으로 처음부터 끝까지 리스트 접근, 그래서 manager가 관리 , 관리하기 위해서는 add로 manager한테 권한주기
        // 그리고 hide로 전부 숨긴다.
        fragments.forEach { (key, frag) ->
            supportFragmentManager.beginTransaction().add(R.id.nav_host_fragment_container, frag, key.toString()).hide(frag).commit()
        }

        // 임의로 4개중에 하나를 화면에 표시한다.
        supportFragmentManager.beginTransaction().show(fragmentHome).commit()
        active = fragmentHome
    }

    // 현재 화면을 숨기고 우리가 선택한 화면을 show한다. 이게 내부적으로 돌아가는 것
    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when(p0.itemId){
            in fragments.keys -> {
                fragments[p0.itemId]?.let {
                    supportFragmentManager.beginTransaction().hide(active).show(it).commit()
                    active = it
                }
            }
            else -> return false
        }
        return true
    }


}
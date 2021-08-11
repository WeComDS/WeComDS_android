package com.example.wsw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    private lateinit var homeFragment: HomeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        homeFragment = HomeFragment.newInstance()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_frame, homeFragment).commit()
        bottom_nav.setOnNavigationItemSelectedListener(onBottomNavItemSelectedListener)
    }
    //바텀 네비게이션 아이템 클릭 리스너 설정
    private val onBottomNavItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
        when(it.itemId){
            R.id.menu_home ->{
                homeFragment = HomeFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragment_frame, homeFragment).commit()
            }
        }

        true
    }

}
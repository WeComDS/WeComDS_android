package com.example.wsw

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when(p0.itemId){
            R.id.menu_home ->{
                var homeFragment = HomeFragment()
                supportFragmentManager.beginTransaction().replace(R.id.fragment_frame,homeFragment).commit()
                return true
            }
            R.id.menu_mail ->{
                var randomMessageFragment = RandomMessageFragment()
                supportFragmentManager.beginTransaction().replace(R.id.fragment_frame,randomMessageFragment).commit()
                return true
            }
//            R.id.menu_groups ->{
//                if(ContextCompat.checkSelfPermission(this,android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
//                    startActivity(Intent(this,AddPhotoActivity::class.java))
//                }
//                return true
//            }

            /*지원이코드
            R.id.menu_home ->{
            homeFragment = HomeFragment.newInstance()
            supportFragmentManager.beginTransaction().replace(R.id.fragment_frame, homeFragment).commit()*/
        }
        return false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 바텀 네비게이션 화면 전환
        bottom_nav.setOnNavigationItemSelectedListener(this)
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), 1)

        bottom_nav.selectedItemId = R.id.menu_home

        /*    지원이 코드
        homeFragment = HomeFragment.newInstance()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_frame, homeFragment).commit()
        bottom_nav.setOnNavigationItemSelectedListener(onBottomNavItemSelectedListener)*/
    }
}
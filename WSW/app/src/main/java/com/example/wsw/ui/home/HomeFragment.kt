package com.example.wsw.ui.home

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.wsw.R
import com.example.wsw.RandomMessageActivity
import com.example.wsw.ui.home.mypage.MypageActivity

class HomeFragment :Fragment(){

    companion object{
        const val TAG: String = "HomeFragment"

        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }
    //메모리에 올라갔을 때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    // 프레그먼트를 안고 있는 액티비티에 붙었을 때
    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        Log.e("fragment","create view")
/*
        // 네비게이션 코드 ( 메인페이지 -> 마이페이지 )
        var img_account = view.findViewById<ImageView>(R.id.img_account)
        img_account.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_home_to_mypage)
        }*/

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        gotomypage()
        gotoNotification()
        gotoRandomMessage()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("fragment","view created")

        init()
    }


    fun init() {

        val settings: SharedPreferences = requireActivity().getSharedPreferences("gitcat", AppCompatActivity.MODE_PRIVATE)

    }

    fun gotomypage(){
        activity?.findViewById<ImageView>(R.id.img_account)?.setOnClickListener {
            startActivity(Intent(context, MypageActivity::class.java))
        }
    }

    fun gotoNotification(){
        activity?.findViewById<ImageView>(R.id.img_notification)?.setOnClickListener {
            startActivity(Intent(context, NotificationActivity::class.java))
        }
    }

    fun gotoRandomMessage(){
        activity?.findViewById<RelativeLayout>(R.id.gotoRandomMsg)?.setOnClickListener {
            startActivity(Intent(context, RandomMessageActivity::class.java))
        }
    }
}

package com.example.wsw

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_home.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment :Fragment(){

    companion object{
        const val TAG: String = "HomeFragment"

        fun newInstance(): HomeFragment{
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("fragment","view created")

        init()
    }


    fun init() {

        val settings: SharedPreferences = requireActivity().getSharedPreferences("gitcat", AppCompatActivity.MODE_PRIVATE)

        //Notification

        //img_notification.setOnClickListener { view ->
        //    val intent = Intent(activity,NotifyActivity::class.java)
        //    startActivity(intent)
        //}

//        img_account.setOnClickListener { view ->
//            val intent = Intent(activity, MypageFragment::class.java)
//            startActivity(intent)
//        }
    }
}

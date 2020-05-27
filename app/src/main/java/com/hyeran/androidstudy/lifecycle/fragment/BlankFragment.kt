package com.hyeran.androidstudy.lifecycle.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction

import com.hyeran.androidstudy.R
import kotlinx.android.synthetic.main.fragment_blank.*

class BlankFragment : Fragment() {

    /** 프래그먼트가 액티비티에 붙을 때 **/
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("=====>", "Fragment Life Cycle: onAttach")
    }

    /** 프래그먼트가 액티비티에 호출을 받아 생성되는 시점 **/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("=====>", "Fragment Life Cycle: onCreate")
    }

    /** 프래그먼트에 속한 각종 view나 viewGroup에 대한 ui 바인딩 작업 **/
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("=====>", "Fragment Life Cycle: onCreateView")
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    /** 액티비티와 프래그먼트가 연결  → 액티비티 onCreate() 다음 호출 **/
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        framelayout_blankfragment.setOnClickListener {
            val fragmentTransaction : FragmentTransaction = activity!!.supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frame_fragment_activity, BlankFragment2())
            fragmentTransaction.commit()
        }
        Log.i("=====>", "Fragment Life Cycle: onActivityCreated")
    }

    /** 프래그먼트가 사용자에게 보여지기 전에 호출 **/
    override fun onStart() {
        super.onStart()
        Log.i("=====>", "Fragment Life Cycle: onStart")
    }

    /** 프래그먼트가 화면에 보여지는 단계 → 사용자와 상호작용 가능 **/
    override fun onResume() {
        super.onResume()
        Log.i("=====>", "Fragment Life Cycle: onResume")
    }

    /** * * * * * * * * 다른 프래그먼트가 add 되는 경우 * * * * * * * * **/

    /** 사용자와의 상호작용 중지 → 다시 돌아온다는 보장 X 중요한 정보 저장 **/
    override fun onPause() {
        super.onPause()
        Log.i("=====>", "Fragment Life Cycle: onPause")
    }

    /** 더이상 보여지지 않음. 프래그먼트 기능 중지 **/
    override fun onStop() {
        super.onStop()
        Log.i("=====>", "Fragment Life Cycle: onStop")
    }

    /** 프래그먼트에 view 제거. back stack 사용 시 돌아올 때 onCreateView() 호출**/
    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("=====>", "Fragment Life Cycle: onDestroyView")
    }

    /** 프래그먼트 제거하기 직전 **/
    override fun onDestroy() {
        super.onDestroy()
        Log.i("=====>", "Fragment Life Cycle: onDestroy")
    }

    /** 프래그먼트 비로소 제거. 액티비티와 연결도 해체 **/
    override fun onDetach() {
        super.onDetach()
        Log.i("=====>", "Fragment Life Cycle: onDetach")
    }
}

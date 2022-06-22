package com.example.studentmanagement.Screen

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studentmanagement.Adapter.MySTU_D_Adapter
import com.example.studentmanagement.R
import com.example.studentmanagement.Utills.DBHelper
import com.example.studentmanagement.Utills.ModelData
import com.example.studentmanagement.databinding.ActivityStudentDetailsBinding

class Student_Details : AppCompatActivity() {

    companion object{
        lateinit var stu_d_binding : ActivityStudentDetailsBinding
    }

    var list = ArrayList<ModelData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        stu_d_binding = ActivityStudentDetailsBinding.inflate(layoutInflater)
        setContentView(stu_d_binding.root)

        val window: Window = this.getWindow()
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.ui))

        stu_d_binding.std1.setOnClickListener {
            stu_d_binding.std1.setCardBackgroundColor(Color.rgb(23,39,140))
            stu_d_binding.std1.setStrokeColor(Color.rgb(23,39,140))
            stu_d_binding.txt1.setTextColor(Color.WHITE)

            cv2()
            cv3()
            cv4()
            cv5()
            cv6()
            cv7()
            cv8()
            cv9()
            cv10()
            cv11()
            cv12()

            list = DBHelper(this).std_readData(stu_d_binding.txt1.text.toString())
            stuSetupRV(list)
        }

        stu_d_binding.std2.setOnClickListener {
            stu_d_binding.std2.setCardBackgroundColor(Color.rgb(23,39,140))
            stu_d_binding.std2.setStrokeColor(Color.rgb(23,39,140))
            stu_d_binding.txt2.setTextColor(Color.WHITE)

            cv1()
            cv3()
            cv4()
            cv5()
            cv6()
            cv7()
            cv8()
            cv9()
            cv10()
            cv11()
            cv12()

            list = DBHelper(this).std_readData(stu_d_binding.txt2.text.toString())
            stuSetupRV(list)
        }

        stu_d_binding.std3.setOnClickListener {
            stu_d_binding.std3.setCardBackgroundColor(Color.rgb(23,39,140))
            stu_d_binding.std3.setStrokeColor(Color.rgb(23,39,140))
            stu_d_binding.txt3.setTextColor(Color.WHITE)

            cv1()
            cv2()
            cv4()
            cv5()
            cv6()
            cv7()
            cv8()
            cv9()
            cv10()
            cv11()
            cv12()

            list = DBHelper(this).std_readData(stu_d_binding.txt3.text.toString())
            stuSetupRV(list)
        }

        stu_d_binding.std4.setOnClickListener {
            stu_d_binding.std4.setCardBackgroundColor(Color.rgb(23,39,140))
            stu_d_binding.std4.setStrokeColor(Color.rgb(23,39,140))
            stu_d_binding.txt4.setTextColor(Color.WHITE)

            cv1()
            cv2()
            cv3()
            cv5()
            cv6()
            cv7()
            cv8()
            cv9()
            cv10()
            cv11()
            cv12()

            list = DBHelper(this).std_readData(stu_d_binding.txt4.text.toString())
            stuSetupRV(list)
        }

        stu_d_binding.std5.setOnClickListener {
            stu_d_binding.std5.setCardBackgroundColor(Color.rgb(23,39,140))
            stu_d_binding.std5.setStrokeColor(Color.rgb(23,39,140))
            stu_d_binding.txt5.setTextColor(Color.WHITE)

            cv1()
            cv2()
            cv3()
            cv4()
            cv6()
            cv7()
            cv8()
            cv9()
            cv10()
            cv11()
            cv12()

            list = DBHelper(this).std_readData(stu_d_binding.txt5.text.toString())
            stuSetupRV(list)
        }

        stu_d_binding.std6.setOnClickListener {
            stu_d_binding.std6.setCardBackgroundColor(Color.rgb(23,39,140))
            stu_d_binding.std6.setStrokeColor(Color.rgb(23,39,140))
            stu_d_binding.txt6.setTextColor(Color.WHITE)

            cv1()
            cv2()
            cv3()
            cv4()
            cv5()
            cv7()
            cv8()
            cv9()
            cv10()
            cv11()
            cv12()

            list = DBHelper(this).std_readData(stu_d_binding.txt6.text.toString())
            stuSetupRV(list)
        }

        stu_d_binding.std7.setOnClickListener {
            stu_d_binding.std7.setCardBackgroundColor(Color.rgb(23,39,140))
            stu_d_binding.std7.setStrokeColor(Color.rgb(23,39,140))
            stu_d_binding.txt7.setTextColor(Color.WHITE)

            cv1()
            cv2()
            cv3()
            cv4()
            cv5()
            cv6()
            cv8()
            cv9()
            cv10()
            cv11()
            cv12()

            list = DBHelper(this).std_readData(stu_d_binding.txt7.text.toString())
            stuSetupRV(list)
        }

        stu_d_binding.std8.setOnClickListener {
            stu_d_binding.std8.setCardBackgroundColor(Color.rgb(23,39,140))
            stu_d_binding.std8.setStrokeColor(Color.rgb(23,39,140))
            stu_d_binding.txt8.setTextColor(Color.WHITE)

            cv1()
            cv2()
            cv3()
            cv4()
            cv5()
            cv6()
            cv7()
            cv9()
            cv10()
            cv11()
            cv12()

            list = DBHelper(this).std_readData(stu_d_binding.txt8.text.toString())
            stuSetupRV(list)
        }

        stu_d_binding.std9.setOnClickListener {
            stu_d_binding.std9.setCardBackgroundColor(Color.rgb(23,39,140))
            stu_d_binding.std9.setStrokeColor(Color.rgb(23,39,140))
            stu_d_binding.txt9.setTextColor(Color.WHITE)

            cv1()
            cv2()
            cv3()
            cv4()
            cv5()
            cv6()
            cv7()
            cv8()
            cv10()
            cv11()
            cv12()

            list = DBHelper(this).std_readData(stu_d_binding.txt9.text.toString())
            stuSetupRV(list)
        }

        stu_d_binding.std10.setOnClickListener {
            stu_d_binding.std10.setCardBackgroundColor(Color.rgb(23,39,140))
            stu_d_binding.std10.setStrokeColor(Color.rgb(23,39,140))
            stu_d_binding.txt10.setTextColor(Color.WHITE)

            cv1()
            cv2()
            cv3()
            cv4()
            cv5()
            cv6()
            cv7()
            cv8()
            cv9()
            cv11()
            cv12()

            list = DBHelper(this).std_readData(stu_d_binding.txt10.text.toString())
            stuSetupRV(list)
        }

        stu_d_binding.std11.setOnClickListener {
            stu_d_binding.std11.setCardBackgroundColor(Color.rgb(23,39,140))
            stu_d_binding.std11.setStrokeColor(Color.rgb(23,39,140))
            stu_d_binding.txt11.setTextColor(Color.WHITE)

            cv1()
            cv2()
            cv3()
            cv4()
            cv5()
            cv6()
            cv7()
            cv8()
            cv9()
            cv10()
            cv12()

            list = DBHelper(this).std_readData(stu_d_binding.txt11.text.toString())
            stuSetupRV(list)
        }

        stu_d_binding.std12.setOnClickListener {
            stu_d_binding.std12.setCardBackgroundColor(Color.rgb(23,39,140))
            stu_d_binding.std12.setStrokeColor(Color.rgb(23,39,140))
            stu_d_binding.txt12.setTextColor(Color.WHITE)

            cv1()
            cv2()
            cv3()
            cv4()
            cv5()
            cv6()
            cv7()
            cv8()
            cv9()
            cv10()
            cv11()

            list = DBHelper(this).std_readData(stu_d_binding.txt12.text.toString())
            stuSetupRV(list)
        }


    }



    fun stuSetupRV(l1: ArrayList<ModelData>){
        var adapter = MySTU_D_Adapter(this,l1)
        var layoutManager = LinearLayoutManager(this)
        stu_d_binding.stuDRv.adapter = adapter
        stu_d_binding.stuDRv.layoutManager = layoutManager

        if(adapter.itemCount == 0){
            stu_d_binding.nodata.visibility = View.VISIBLE;
        }
        else{
            stu_d_binding.nodata.visibility = View.GONE;
        }
    }

    fun cv1(){
        stu_d_binding.std1.setCardBackgroundColor(Color.WHITE)
        stu_d_binding.std1.setStrokeColor(Color.BLACK)
        stu_d_binding.txt1.setTextColor(Color.BLACK)
    }

    fun cv2(){
        stu_d_binding.std2.setCardBackgroundColor(Color.WHITE)
        stu_d_binding.std2.setStrokeColor(Color.BLACK)
        stu_d_binding.txt2.setTextColor(Color.BLACK)
    }

    fun cv3(){
        stu_d_binding.std3.setCardBackgroundColor(Color.WHITE)
        stu_d_binding.std3.setStrokeColor(Color.BLACK)
        stu_d_binding.txt3.setTextColor(Color.BLACK)
    }

    fun cv4(){
        stu_d_binding.std4.setCardBackgroundColor(Color.WHITE)
        stu_d_binding.std4.setStrokeColor(Color.BLACK)
        stu_d_binding.txt4.setTextColor(Color.BLACK)
    }

    fun cv5(){
        stu_d_binding.std5.setCardBackgroundColor(Color.WHITE)
        stu_d_binding.std5.setStrokeColor(Color.BLACK)
        stu_d_binding.txt5.setTextColor(Color.BLACK)
    }

    fun cv6(){
        stu_d_binding.std6.setCardBackgroundColor(Color.WHITE)
        stu_d_binding.std6.setStrokeColor(Color.BLACK)
        stu_d_binding.txt6.setTextColor(Color.BLACK)
    }

    fun cv7(){
        stu_d_binding.std7.setCardBackgroundColor(Color.WHITE)
        stu_d_binding.std7.setStrokeColor(Color.BLACK)
        stu_d_binding.txt7.setTextColor(Color.BLACK)
    }

    fun cv8(){
        stu_d_binding.std8.setCardBackgroundColor(Color.WHITE)
        stu_d_binding.std8.setStrokeColor(Color.BLACK)
        stu_d_binding.txt8.setTextColor(Color.BLACK)
    }

    fun cv9(){
        stu_d_binding.std9.setCardBackgroundColor(Color.WHITE)
        stu_d_binding.std9.setStrokeColor(Color.BLACK)
        stu_d_binding.txt9.setTextColor(Color.BLACK)
    }

    fun cv10(){
        stu_d_binding.std10.setCardBackgroundColor(Color.WHITE)
        stu_d_binding.std10.setStrokeColor(Color.BLACK)
        stu_d_binding.txt10.setTextColor(Color.BLACK)
    }

    fun cv11(){
        stu_d_binding.std11.setCardBackgroundColor(Color.WHITE)
        stu_d_binding.std11.setStrokeColor(Color.BLACK)
        stu_d_binding.txt11.setTextColor(Color.BLACK)
    }

    fun cv12(){
        stu_d_binding.std12.setCardBackgroundColor(Color.WHITE)
        stu_d_binding.std12.setStrokeColor(Color.BLACK)
        stu_d_binding.txt12.setTextColor(Color.BLACK)
    }


    override fun onResume() {
        super.onResume()

            stu_d_binding.std1.setCardBackgroundColor(Color.rgb(23,39,140))
            stu_d_binding.std1.setStrokeColor(Color.rgb(23,39,140))
            stu_d_binding.txt1.setTextColor(Color.WHITE)

            cv2()
            cv3()
            cv4()
            cv5()
            cv6()
            cv7()
            cv8()
            cv9()
            cv10()
            cv11()
            cv12()

            list = DBHelper(this).std_readData(stu_d_binding.txt1.text.toString())
            stuSetupRV(list)

    }

}
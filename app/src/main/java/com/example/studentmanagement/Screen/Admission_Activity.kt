package com.example.studentmanagement.Screen

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studentmanagement.Adapter.MyAD_Adapter
import com.example.studentmanagement.R
import com.example.studentmanagement.Utills.DBHelper
import com.example.studentmanagement.Utills.ModelData
import com.example.studentmanagement.databinding.ActivityAdmissionBinding


class Admission_Activity : AppCompatActivity() {

    var list = ArrayList<ModelData>()

    companion object {
        lateinit var ad_binding: ActivityAdmissionBinding
    }

    var db = DBHelper(this)
    var status : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ad_binding = ActivityAdmissionBinding.inflate(layoutInflater)
        setContentView(ad_binding.root)

        val window: Window = this.getWindow()
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.ui))

        ad_binding.filter.setOnClickListener {
            dg_filter()
        }

        ad_binding.plusBtn.setOnClickListener {

            var intent = Intent(this, Admission_form::class.java)
            startActivity(intent)

        }

        ad_binding.searchImg.setOnClickListener {

            var id = ad_binding.searchEdt.text.toString().toInt()

            var l1 = DBHelper(this).profile_readData(id)
            setupRV(l1)
        }

    }

    fun setupRV(l1: ArrayList<ModelData>) {

        var adapter = MyAD_Adapter(this, l1)
        var layoutmanager = LinearLayoutManager(this)
        ad_binding.admissionRv.layoutManager = layoutmanager
        ad_binding.admissionRv.adapter = adapter

        if(adapter.itemCount == 0){
            ad_binding.nodata.visibility = View.VISIBLE;
        }
        else{
            ad_binding.nodata.visibility = View.GONE;
        }

    }

    override fun onResume() {
        super.onResume()

        list = db.readData()
        setupRV(list)

    }

    fun dg_filter() {

        var dialog = Dialog(this)
        dialog.setContentView(R.layout.dg_filter)
        dialog.setCancelable(false)

        var rd_grp = dialog.findViewById<RadioGroup>(R.id.rd_grp)
        var filter_btn = dialog.findViewById<Button>(R.id.filter_btn)

        dialog.show()

        filter_btn.setOnClickListener {

            if(rd_grp.checkedRadioButtonId == R.id.all){
                var l1 = DBHelper(this).readData()
                setupRV(l1)

                dialog.dismiss()
            }
            else{
                when (rd_grp.checkedRadioButtonId) {
                    R.id.rd_1 -> {
                        status = "1"
                    }
                    R.id.rd_2 -> {
                        status = "2"
                    }
                    R.id.rd_3 -> {
                        status = "3"
                    }
                    R.id.rd_4 -> {
                        status = "4"
                    }
                    R.id.rd_5 -> {
                        status = "5"
                    }
                    R.id.rd_6 -> {
                        status = "6"
                    }
                    R.id.rd_7 -> {
                        status = "7"
                    }
                    R.id.rd_8 -> {
                        status = "8"
                    }
                    R.id.rd_9 -> {
                        status = "9"
                    }
                    R.id.rd_10 -> {
                        status = "10"
                    }
                    R.id.rd_11 -> {
                        status = "11"
                    }
                    R.id.rd_12 -> {
                        status = "12"
                    }

                }

                var l1 = DBHelper(this).std_readData(status)
                setupRV(l1)

                dialog.dismiss()
            }

        }

    }

}
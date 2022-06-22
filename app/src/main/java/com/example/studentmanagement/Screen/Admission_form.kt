package com.example.studentmanagement.Screen

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.RadioGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.studentmanagement.R
import com.example.studentmanagement.databinding.ActivityAdmissionBinding
import com.example.studentmanagement.databinding.ActivityAdmissionFormBinding

class Admission_form : AppCompatActivity() {

    companion object{
        lateinit var ad_f_binding : ActivityAdmissionFormBinding
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ad_f_binding = ActivityAdmissionFormBinding.inflate(layoutInflater)
        setContentView(ad_f_binding.root)

        val window: Window = this.getWindow()
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.ui))

        ad_f_binding.nxtBtn.setOnClickListener {

            if(ad_f_binding.nameEdt.length()==0){
                ad_f_binding.nameOutlineEdt.error = "Error"
            }
            else if(ad_f_binding.fnameEdt.length()==0){
                ad_f_binding.fnameOutlineEdt.error = "Error"
            }
            else if(ad_f_binding.snameEdt.length()==0){
                ad_f_binding.snameOutlineEdt.error = "Error"
            }
            else if(ad_f_binding.mnameEdt.length()==0){
                ad_f_binding.mnameOutlineEdt.error = "Error"
            }
            else if(ad_f_binding.mobileEdt.length()==0){
                ad_f_binding.mobileOutlineEdt.error = "Error"
            }
            else if(ad_f_binding.mobileEdt.length()!=10){
                ad_f_binding.mobileEdt.error = "Invalid Mobile NUmber"
            }
            else if(ad_f_binding.mailEdt.length()==0){
                ad_f_binding.mailOutlineEdt.error = "Error"
            }
            else if(ad_f_binding.addEdt.length()==0){
                ad_f_binding.addOutlineEdt.error = "Error"
            }
            else{
                finish()
                val intent =  Intent(this,Admission_form2::class.java)
                startActivity(intent)
            }
        }

    }

}
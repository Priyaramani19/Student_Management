package com.example.studentmanagement.Screen

import android.app.DatePickerDialog
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.studentmanagement.R
import com.example.studentmanagement.Screen.Admission_form.Companion.ad_f_binding
import com.example.studentmanagement.Utills.DBHelper
import com.example.studentmanagement.Utills.ModelData
import com.example.studentmanagement.databinding.ActivityAdmissionForm2Binding
import java.util.*
import kotlin.collections.ArrayList

class Admission_form2 : AppCompatActivity() {

    companion object{
        lateinit var ad_f2_binding: ActivityAdmissionForm2Binding
        var type = ""
    }

    var db = DBHelper(this)
    var list = ArrayList<ModelData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ad_f2_binding = ActivityAdmissionForm2Binding.inflate(layoutInflater)
        setContentView(ad_f2_binding.root)

        val window: Window = this.getWindow()
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.ui))

        ad_f2_binding.bdateEdt.setOnClickListener {

            val calendar= Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(this, R.style.MyDatePickerStyle , DatePickerDialog.OnDateSetListener
            { view, year, monthOfYear, dayOfMonth ->
                ad_f2_binding.bdateEdt.setText("" + dayOfMonth + " - " + (monthOfYear+1) + " - " + year)
            }, year, month, day)
            datePickerDialog.show()
            datePickerDialog.getButton(DatePickerDialog.BUTTON_NEGATIVE).setTextColor(Color.rgb(23,39,140))
            datePickerDialog.getButton(DatePickerDialog.BUTTON_POSITIVE).setTextColor(Color.rgb(23,39,140))
        }

        ad_f2_binding.saveBtn.setOnClickListener {

            if(ad_f2_binding.bdateEdt.length()==0){
                ad_f2_binding.bdateOutlineEdt.error = "Error"
            }
            else if(ad_f2_binding.ageEdt.length()==0){
                ad_f2_binding.ageOutlineEdt.error = "Error"
            }
            else if(ad_f2_binding.stdEdt.length()==0){
                ad_f2_binding.stdOutlineEdt.error = "Error"
            }
            else if(ad_f2_binding.stdEdt.text.toString().toInt()<=0 || ad_f2_binding.stdEdt.text.toString().toInt()>12){
                ad_f2_binding.stdOutlineEdt.error = "Invalid Standard"
                Toast.makeText(this,"Enter Valid Standard",Toast.LENGTH_LONG).show()
            }
            else if(ad_f2_binding.amountEdt.length()==0){
                ad_f2_binding.amountOutlineEdt.error = "Error"
            }
            else if(ad_f2_binding.rdGrp.checkedRadioButtonId == -1){
                ad_f2_binding.cashRdBtn.error = "Error"
            }
            else{
                if (ad_f2_binding.rdGrp.getCheckedRadioButtonId() == R.id.cash_rd_btn) {
                    type = "Cash"
                }
                else if(ad_f2_binding.rdGrp.getCheckedRadioButtonId() == R.id.credit_rd_btn){
                    type = "Credit"
                }

                db.insertData(ad_f_binding.nameEdt.text.toString(),ad_f_binding.fnameEdt.text.toString(),ad_f_binding.snameEdt.text.toString(),ad_f_binding.mnameEdt.text.toString(),ad_f_binding.mobileEdt.text.toString(),ad_f_binding.mailEdt.text.toString(),
                    ad_f_binding.addEdt.text.toString(),ad_f2_binding.bdateEdt.text.toString(),ad_f2_binding.ageEdt.text.toString(),ad_f2_binding.stdEdt.text.toString(),ad_f2_binding.amountEdt.text.toString(),type)


                finish()
            }
        }

    }

}


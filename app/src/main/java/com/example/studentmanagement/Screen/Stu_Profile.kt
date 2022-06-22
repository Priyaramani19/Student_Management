package com.example.studentmanagement.Screen

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.studentmanagement.R
import com.example.studentmanagement.Utills.DBHelper
import com.example.studentmanagement.Utills.ModelData
import com.example.studentmanagement.databinding.ActivityStuProfileBinding

class Stu_Profile : AppCompatActivity() {

    companion object {
        lateinit var stu_pro_binding: ActivityStuProfileBinding
    }

    lateinit var list: ArrayList<ModelData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        stu_pro_binding = ActivityStuProfileBinding.inflate(layoutInflater)
        setContentView(stu_pro_binding.root)

        val window: Window = this.getWindow()
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.ui))

        var id = intent.getStringExtra("n1")
        Toast.makeText(this, "$id", Toast.LENGTH_SHORT).show()

        var id1 = id!!.toInt()

        list = DBHelper(this).profile_readData(id1)

        stu_pro_binding.surnameFill.text = list[0].surname
        stu_pro_binding.nameFill.text = list[0].name
        stu_pro_binding.fnameFill.text = list[0].fathername
        stu_pro_binding.mnameFill.text = list[0].mothername
        stu_pro_binding.mailFill.text = list[0].mail
        stu_pro_binding.addFill.text = list[0].address
        stu_pro_binding.bdateFill.text = list[0].bdate
        stu_pro_binding.ageFill.text = list[0].age
        stu_pro_binding.stdFill.text = list[0].std

        stu_pro_binding.edit.setOnClickListener {
            editDialog(id1)
        }


    }

    fun editDialog(id1: Int) {
        var d1 = Dialog(this)
        d1.setContentView(R.layout.dg_item)
        d1.setCancelable(false)
        d1.show()

        var name_edt = d1.findViewById<EditText>(R.id.name_edt)
        var fname_edt = d1.findViewById<EditText>(R.id.fname_edt)
        var sname_edt = d1.findViewById<EditText>(R.id.sname_edt)
        var mname_edt = d1.findViewById<EditText>(R.id.mname_edt)
        var mobile_edt = d1.findViewById<EditText>(R.id.mobile_edt)
        var mail_edt = d1.findViewById<EditText>(R.id.mail_edt)
        var add_edt = d1.findViewById<EditText>(R.id.add_edt)
        var bdate_edt = d1.findViewById<EditText>(R.id.bdate_edt)
        var age_edt = d1.findViewById<EditText>(R.id.age_edt)
        var std_edt = d1.findViewById<EditText>(R.id.std_edt)
        var save_btn = d1.findViewById<Button>(R.id.save_btn)


        name_edt.setText(list[0].name, TextView.BufferType.EDITABLE)
        fname_edt.setText(list[0].fathername, TextView.BufferType.EDITABLE)
        sname_edt.setText(list[0].surname, TextView.BufferType.EDITABLE)
        mname_edt.setText(list[0].mothername, TextView.BufferType.EDITABLE)
        mobile_edt.setText(list[0].mobile, TextView.BufferType.EDITABLE)
        mail_edt.setText(list[0].mail, TextView.BufferType.EDITABLE)
        add_edt.setText(list[0].address, TextView.BufferType.EDITABLE)
        bdate_edt.setText(list[0].bdate, TextView.BufferType.EDITABLE)
        age_edt.setText(list[0].age, TextView.BufferType.EDITABLE)
        std_edt.setText(list[0].std, TextView.BufferType.EDITABLE)

        save_btn.setOnClickListener {

            DBHelper(this).updateData(
                list[0].id,
                name_edt.text.toString(),
                fname_edt.text.toString(),
                sname_edt.text.toString(),
                mname_edt.text.toString(),
                mobile_edt.text.toString(),
                mail_edt.text.toString(),
                add_edt.text.toString(),
                bdate_edt.text.toString(),
                age_edt.text.toString(),
                std_edt.text.toString()
            )

            var l1 = DBHelper(this).profile_readData(id1)

            stu_pro_binding.surnameFill.text = l1[0].surname
            stu_pro_binding.nameFill.text = l1[0].name
            stu_pro_binding.fnameFill.text = l1[0].fathername
            stu_pro_binding.mnameFill.text = l1[0].mothername
            stu_pro_binding.mailFill.text = l1[0].mail
            stu_pro_binding.addFill.text = l1[0].address
            stu_pro_binding.bdateFill.text = l1[0].bdate
            stu_pro_binding.ageFill.text = l1[0].age
            stu_pro_binding.stdFill.text = l1[0].std

            d1.dismiss()
        }
    }
}





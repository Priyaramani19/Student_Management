package com.example.studentmanagement.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.studentmanagement.R
import com.example.studentmanagement.Screen.Stu_Profile
import com.example.studentmanagement.Screen.Student_Details
import com.example.studentmanagement.Utills.DBHelper
import com.example.studentmanagement.Utills.ModelData

class MySTU_D_Adapter(val studentDetails: Student_Details, val list: ArrayList<ModelData>) : RecyclerView.Adapter<MySTU_D_Adapter.ViewData>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewData {
        var view = LayoutInflater.from(studentDetails).inflate(R.layout.stu_d_item,parent,false)

        return ViewData(view)
    }

    override fun onBindViewHolder(holder: ViewData, position: Int) {

        var p1 = position+1

        holder.stu_id.text = p1.toString()
        holder.s_surname.text = list[position].surname
        holder.s_name.text = list[position].name
        holder.s_fname.text = list[position].fathername
        holder.s_std.text = list[position].std

        holder.delete_img.setOnClickListener {
            DBHelper(studentDetails).deleteData(list[position].id)

            var l1 = DBHelper(studentDetails).std_readData(Student_Details.stu_d_binding.txt1.text.toString())
            studentDetails.stuSetupRV(l1)
        }

        holder.cv.setOnClickListener {

            var intent = Intent(studentDetails,Stu_Profile::class.java)
            intent.putExtra("n1",list[position].id)
            studentDetails.startActivity(intent)

        }
    }

    override fun getItemCount(): Int {
        return  list.size
    }

    class ViewData(itemView: View) : RecyclerView.ViewHolder(itemView){
        var stu_id = itemView.findViewById<TextView>(R.id.stu_id)
        var s_name = itemView.findViewById<TextView>(R.id.s_name)
        var s_surname = itemView.findViewById<TextView>(R.id.s_surname)
        var s_fname = itemView.findViewById<TextView>(R.id.s_fname)
        var s_std = itemView.findViewById<TextView>(R.id.s_std)
        var cv = itemView.findViewById<CardView>(R.id.cv)
        var delete_img = itemView.findViewById<ImageView>(R.id.delete_img)
    }

}


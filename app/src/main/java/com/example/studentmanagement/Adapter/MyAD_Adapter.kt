package com.example.studentmanagement.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.studentmanagement.R
import com.example.studentmanagement.Screen.Admission_Activity
import com.example.studentmanagement.Utills.ModelData

class MyAD_Adapter(val admissionActivity: Admission_Activity, val list: ArrayList<ModelData>) : RecyclerView.Adapter<MyAD_Adapter.ViewData>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewData {
        var view = LayoutInflater.from(admissionActivity).inflate(R.layout.ad_item,parent,false)

        return ViewData(view)
    }

    override fun onBindViewHolder(holder: ViewData, position: Int) {
        holder.id.text = list[position].id
        holder.surname.text = list[position].surname
        holder.name.text = list[position].name
        holder.fname.text = list[position].fathername
        holder.std.text = list[position].std
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewData(itemView: View) : RecyclerView.ViewHolder(itemView){
        var id = itemView.findViewById<TextView>(R.id.id)
        var surname = itemView.findViewById<TextView>(R.id.surname)
        var name = itemView.findViewById<TextView>(R.id.name)
        var fname = itemView.findViewById<TextView>(R.id.fname)
        var std = itemView.findViewById<TextView>(R.id.std)
    }

}
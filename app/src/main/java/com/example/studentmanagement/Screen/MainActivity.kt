package com.example.studentmanagement.Screen

import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.studentmanagement.R
import com.example.studentmanagement.Utills.DBHelper
import com.example.studentmanagement.databinding.ActivityMainBinding
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem


class MainActivity : AppCompatActivity() {

    companion object{
        lateinit var main_binding : ActivityMainBinding
    }

    var db = DBHelper(this)
    var list = ArrayList<CarouselItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        main_binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(main_binding.root)

        loadImage()

        val window: Window = this.getWindow()
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.ui))

        main_binding.admissionCv.setOnClickListener {

            var intent = Intent(this,Admission_Activity::class.java)
            startActivity(intent)

        }

        main_binding.stuDetailsCv.setOnClickListener {

            var intent = Intent(this,Student_Details::class.java)
            startActivity(intent)

        }


    }

    fun loadImage(){

        list.add(
            CarouselItem(
                imageUrl = "https://www.southbank.org/wp-content/uploads/sites/49/2020/03/shutterstock_550767073.jpg"
            )
        )

        list.add(
            CarouselItem(
                imageUrl = "https://mybayutcdn.bayut.com/mybayut/wp-content/uploads/elite-english.jpg"
            )
        )

        list.add(
            CarouselItem(
                imageUrl = "https://vkrf.ru/wp-content/uploads/2015/11/gallery_10.jpg"
            )
        )

        main_binding.carousel.setData(list)
    }

}


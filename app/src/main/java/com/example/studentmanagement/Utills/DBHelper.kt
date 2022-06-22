package com.example.studentmanagement.Utills

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context?) : SQLiteOpenHelper(context, "MyDB.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        var query = "CREATE TABLE student (id INTEGER PRIMARY KEY AUTOINCREMENT , name TEXT , fathername TEXT , surname TEXT , mothername TEXT , mobile TEXT , mail TEXT , address TEXT , bdate TEXT , age TEXT , std TEXT , amount TEXT , type TEXT)"

        db!!.execSQL(query)
    }



    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }


    fun insertData(name:String , fathername:String , surname:String , mothername:String , mobile:String , mail:String , address:String , bdate:String , age:String , std:String , amount:String , type:String){

        var db = writableDatabase

        var cv = ContentValues()
        cv.put("name",name)
        cv.put("fathername",fathername)
        cv.put("surname",surname)
        cv.put("mothername",mothername)
        cv.put("mobile",mobile)
        cv.put("mail",mail)
        cv.put("address",address)
        cv.put("bdate",bdate)
        cv.put("age",age)
        cv.put("std",std)
        cv.put("amount",amount)
        cv.put("type",type)


        var res = db.insert("student",null,cv)
        println(res)
    }



    @SuppressLint("Range")
    fun readData(): ArrayList<ModelData> {

        var list = arrayListOf<ModelData>()

        var db = readableDatabase

        var query = "SELECT * FROM student"

        var cursor = db.rawQuery(query,null)

        if(cursor.moveToFirst()){

            do{

                var id = cursor.getString(cursor.getColumnIndex("id"))
                var name = cursor.getString(cursor.getColumnIndex("name"))
                var fathername = cursor.getString(cursor.getColumnIndex("fathername"))
                var surname = cursor.getString(cursor.getColumnIndex("surname"))
                var mothername = cursor.getString(cursor.getColumnIndex("mothername"))
                var mobile = cursor.getString(cursor.getColumnIndex("mobile"))
                var mail = cursor.getString(cursor.getColumnIndex("mail"))
                var address = cursor.getString(cursor.getColumnIndex("address"))
                var bdate = cursor.getString(cursor.getColumnIndex("bdate"))
                var age = cursor.getString(cursor.getColumnIndex("age"))
                var std = cursor.getString(cursor.getColumnIndex("std"))
                var amount = cursor.getString(cursor.getColumnIndex("amount"))
                var type = cursor.getString(cursor.getColumnIndex("type"))

                var modelData =  ModelData(id,name,fathername,surname,mothername,mobile,mail,address,bdate,age,std,amount,type)
                list.add(modelData)

            }while (cursor.moveToNext())
        }

        return list

    }



    @SuppressLint("Range")
    fun std_readData(s: String): ArrayList<ModelData> {

        var list = arrayListOf<ModelData>()

        var db = readableDatabase

        var query = "SELECT * FROM student where std = $s"

        var cursor = db.rawQuery(query,null)

        if(cursor.moveToFirst()){

            do{

                var id = cursor.getString(cursor.getColumnIndex("id"))
                var name = cursor.getString(cursor.getColumnIndex("name"))
                var fathername = cursor.getString(cursor.getColumnIndex("fathername"))
                var surname = cursor.getString(cursor.getColumnIndex("surname"))
                var mothername = cursor.getString(cursor.getColumnIndex("mothername"))
                var mobile = cursor.getString(cursor.getColumnIndex("mobile"))
                var mail = cursor.getString(cursor.getColumnIndex("mail"))
                var address = cursor.getString(cursor.getColumnIndex("address"))
                var bdate = cursor.getString(cursor.getColumnIndex("bdate"))
                var age = cursor.getString(cursor.getColumnIndex("age"))
                var std = cursor.getString(cursor.getColumnIndex("std"))
                var amount = cursor.getString(cursor.getColumnIndex("amount"))
                var type = cursor.getString(cursor.getColumnIndex("type"))

                var modelData =  ModelData(id,name,fathername,surname,mothername,mobile,mail,address,bdate,age,std,amount,type)
                list.add(modelData)

            }while (cursor.moveToNext())
        }

        return list

    }



    @SuppressLint("Range")
    fun profile_readData(s: Int): ArrayList<ModelData> {

        var list = arrayListOf<ModelData>()

        var db = readableDatabase

        var query = "SELECT * FROM student where id = $s"

        var cursor = db.rawQuery(query,null)

        if(cursor.moveToFirst()){

            do{

                var id = cursor.getString(cursor.getColumnIndex("id"))
                var name = cursor.getString(cursor.getColumnIndex("name"))
                var fathername = cursor.getString(cursor.getColumnIndex("fathername"))
                var surname = cursor.getString(cursor.getColumnIndex("surname"))
                var mothername = cursor.getString(cursor.getColumnIndex("mothername"))
                var mobile = cursor.getString(cursor.getColumnIndex("mobile"))
                var mail = cursor.getString(cursor.getColumnIndex("mail"))
                var address = cursor.getString(cursor.getColumnIndex("address"))
                var bdate = cursor.getString(cursor.getColumnIndex("bdate"))
                var age = cursor.getString(cursor.getColumnIndex("age"))
                var std = cursor.getString(cursor.getColumnIndex("std"))
                var amount = cursor.getString(cursor.getColumnIndex("amount"))
                var type = cursor.getString(cursor.getColumnIndex("type"))

                var modelData =  ModelData(id,name,fathername,surname,mothername,mobile,mail,address,bdate,age,std,amount,type)
                list.add(modelData)

            }while (cursor.moveToNext())
        }

        return list

    }



    fun deleteData(id:String){

        var db = writableDatabase

        db.delete("student","id = $id", null)

    }



    fun updateData(id:String , name:String , fathername:String , surname:String , mothername:String , mobile:String , mail:String , address:String , bdate:String , age:String , std:String){

        var db = writableDatabase

        var cv = ContentValues()
        cv.put("name",name)
        cv.put("fathername",fathername)
        cv.put("surname",surname)
        cv.put("mothername",mothername)
        cv.put("mobile",mobile)
        cv.put("mail",mail)
        cv.put("address",address)
        cv.put("bdate",bdate)
        cv.put("age",age)
        cv.put("std",std)


        db.update("student",cv,"id = $id",null)

    }

}
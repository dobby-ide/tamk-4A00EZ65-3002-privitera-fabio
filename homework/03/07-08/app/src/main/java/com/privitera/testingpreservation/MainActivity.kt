package com.privitera.testingpreservation

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import java.util.*;

class MainActivity : AppCompatActivity() {
    lateinit var editText: EditText

    fun onPress(view: View){
        val intent = Intent(this, ActivityB::class.java)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var date: Date = Date()
        this.setTitle(date.toString())


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("content", this.title.toString())
        Log.d("MainActivity", "onSaveInstanceState()")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val str = savedInstanceState.get("content")
        this.setTitle(str.toString())
        Log.d("MainActivity", "onRestoreInstanceState()")
    }
}
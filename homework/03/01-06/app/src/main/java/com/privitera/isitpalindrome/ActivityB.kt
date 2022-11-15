package com.privitera.isitpalindrome

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class ActivityB : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var phoneNumberInput :EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)
        val myintent = intent
       var b:String? = getIntent().getStringExtra("yesorno")
        Log.d("second activity", b.toString())
        textView = findViewById(R.id.textViewSA)
        textView.text = b
        phoneNumberInput = findViewById<EditText>(R.id.phoneNumberInput)
    }

    override fun onBackPressed() {
        // Send name = jaska back to first activity
        val intent = Intent()
        intent.putExtra("name", phoneNumberInput.text.toString())
        setResult(RESULT_OK, intent);
        super.onBackPressed()
    }
}
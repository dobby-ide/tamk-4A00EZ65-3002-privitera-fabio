package com.privitera.isitpalindrome

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.widget.addTextChangedListener



class MainActivity : AppCompatActivity() {

    lateinit var inputWord:EditText
    lateinit var answerText: TextView
    lateinit var phoneNumberText :TextView
    lateinit var openDialer :Button
    //ACTIVITY B-->ACTIVITY A
    fun openSomeActivityForResult() {
        val intent = Intent(this,ActivityB::class.java)
        resultLauncher.launch(intent)
    }

    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            // There are no request codes
            val data: Intent? = result.data
            var nameFromSecondActivity:String? =  data!!.getStringExtra("name").toString()
            println(nameFromSecondActivity)
            phoneNumberText.text = nameFromSecondActivity

        }
    }
            //Kotlin extensions
    fun EditText.addMyKeyListener(callback:(datas:String)->Unit){
        //here we create an anonymous function that reference an abstract class
        //therefore object is used because abstract classes cant be instantiated directly
        this.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable?) {
                println(s)

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                println(s)
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                var original = s.toString()
                callback(original)
//                val result = if(original.isPalindrome()) "YES" else "NO"
//                answerText.text=result
            }
        })

    }

    fun onPress(view: View){
        /*Log.d("inside main", "button pressed")
        Log.d("myword:" , inputWord.text.toString())*/
        var original = inputWord.text.toString()
        val result =  if(original.isPalindrome()) "YES" else "NO"
        openSomeActivityForResult()
//        answerText.text=result


        val intent = Intent(this, ActivityB::class.java)
        intent.putExtra("yesorno", result)
        startActivity(intent)
        }

        fun String.isPalindrome():Boolean{
            var original = this
            var reverse = ""
                for (i in original.length-1 downTo 0) {
                var t: Char = original[i].toChar()
                reverse+=t
            }
            return reverse==original
        }

    fun onOpeningDials(view: View){
        val intent2 = Intent(Intent.ACTION_DIAL, Uri.parse("tel://"+phoneNumberText.text.toString()))
       startActivity(intent2)

    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "onCreate called")
        setContentView(R.layout.activity_main)
        var b:Button = findViewById<Button>(R.id.button)
        inputWord = findViewById<EditText>(R.id.editText)
        answerText = findViewById(R.id.textView2)
        phoneNumberText = findViewById(R.id.phoneText)
        openDialer = findViewById(R.id.opendial)

        this.inputWord.addMyKeyListener {  answerText.text = if(it.isPalindrome()) "YES" else "NO" }
       /* inputWord.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable?) {
                println(s)
               *//* var original = s.toString()
                val result = if(original.isPalindrome()) "YES" else "NO"
                answerText.text=result*//*
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                println(s)
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                var original = s.toString()
                val result = if(original.isPalindrome()) "YES" else "NO"
                answerText.text=result
            }
        }
        )*/
    }
    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop() called")

    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity","onResume() called" )
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "OnPause() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "OnDestroy()")
    }
}
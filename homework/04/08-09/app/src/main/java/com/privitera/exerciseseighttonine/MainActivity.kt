package com.privitera.exerciseseighttonine

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var receiver : MyBGReceiver
    lateinit var myService:Intent
    lateinit var textInput : EditText
    lateinit var playButton: Button
    lateinit var stopButton: Button
    //receiving signals from the service
    inner class MyBGReceiver: BroadcastReceiver() {
        @SuppressLint("NewApi")
        override fun onReceive(context: Context?, intent: Intent?) {
            var action = intent!!.action.toString()
            when(action){
                "fi.tuni.tamk.disableStopbutton"->{
                    stopButton.setEnabled(false)
                    playButton.setEnabled(true)
                }
                "fi.tuni.tamk.disablePlaybutton"->{
                    playButton.setEnabled(false)
                    stopButton.setEnabled(true)
                }
                "fi.tuni.tamk.songisfinished"->{
                    stopButton.setEnabled(false)
                    playButton.setEnabled(true)
                }

            }

        }
    }
    fun start(view: View){
        println(textInput.text)
        val action = "PLAY"
        myService = Intent(this, BGMusicService::class.java)
        myService.action = action
        myService.putExtra("url","https://www.learningcontainer.com/wp-content/uploads/2020/02/Kalimba-online-audio-converter.com_-1.wav") //this is hardcoded but can be easily retrieved from text input, For TESTING PURPOSES
        startService(myService)
        //startService(Intent(this, BGMusicService::class.java))

    }

    fun stop(view:View){
        myService = Intent(this, BGMusicService::class.java)
        myService.action = "STOP"
        startService(myService)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        playButton = findViewById(R.id.startButton)
        stopButton = findViewById(R.id.stopButton)
        textInput = findViewById(R.id.editText)
        receiver = MyBGReceiver()
    }
    override fun onResume() {
        super.onResume()
//        registerReceiver(receiver, IntentFilter(ACTION_TIME_TICK));
        registerReceiver(receiver, IntentFilter("fi.tuni.tamk.disableStopbutton"));
        registerReceiver(receiver, IntentFilter("fi.tuni.tamk.disablePlaybutton"));
        registerReceiver(receiver, IntentFilter("fi.tuni.tamk.songisfinished"));
    }
}
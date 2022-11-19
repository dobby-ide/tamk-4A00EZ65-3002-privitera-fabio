package com.privitera.exerciseonetoseven

import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.Intent.ACTION_TIME_TICK
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var button: Button
    lateinit var textView: TextView
    lateinit var stopButton: Button
    lateinit var receiver: MyBroadCastReceiver2

//  Do a receiver work the same way if it is not in AndroidManifest.xml? I suppose it would only work locally to the app
    inner class MyBroadCastReceiver2 : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
           var str =intent!!.getIntExtra("data",0).toString()
            textView.text=str
            Log.d("BroadCastReceiver2", str)
            Log.d("BroadCastReceiver2",Thread.currentThread().name)
        }
    }
    fun onPress(view: View){
        startService(Intent(this, MyBackgroundService::class.java))
        Log.d("exercise", "button clicked")
        var counter = 0
       /* val t = Thread() {
            while(counter < 10){
                Thread.sleep(1000)
                counter++

                runOnUiThread() {
                    textView.text=counter.toString()
                }
                println(counter)
                Log.d("exercise", Thread.currentThread().name)
            }
        }
            t.start()*/
    }
    //Stops the service
    fun stop(view:View){
        stopService(Intent(this, MyBackgroundService::class.java))
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        receiver= MyBroadCastReceiver2()
    }


    override fun onResume() {
        super.onResume()
//        registerReceiver(receiver, IntentFilter(ACTION_TIME_TICK));
        registerReceiver(receiver, IntentFilter("fi.tuni.tamk.test"));
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(receiver)
    }
}
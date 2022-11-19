package com.privitera.exerciseonetoseven
//Tread is not destroyed!!
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyBackgroundService : Service() {
    lateinit var t :Thread
    var bool :Boolean = false
    // We are not using binded service, service can only be started and stopped
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
    override fun onCreate(){
        bool=true
        var counter = 0

        val t = Thread() {
            while(bool){
                Thread.sleep(1000)
                counter++
                var intent = Intent().also { intent ->
                    intent.setAction("fi.tuni.tamk.test")
                    intent.putExtra("data", counter)
                    sendBroadcast(intent)
                }
                println(counter)
                //it is sending a broadcast --< the broadcast needs being registered????
                Log.d("BroadCastReceiver2", Thread.currentThread().name)


            }
        }
        t.start()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("exercise", "service started")
        // If service is killed by android, it will try to start it again when
                if(!bool){
                    t.start()
                }
                 return START_STICKY
             }


    override fun stopService(name: Intent?): Boolean {
        return super.stopService(name)
    }

    override fun onDestroy() {
        Log.d("exercise", "service stopped")
        bool=false
        super.onDestroy()
    }

}
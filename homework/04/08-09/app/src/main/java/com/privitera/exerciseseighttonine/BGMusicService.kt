package com.privitera.exerciseseighttonine

import android.app.Service
import android.content.Intent
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.media.MediaPlayer.OnCompletionListener
import android.os.IBinder
import android.widget.Toast




class BGMusicService: Service(), MediaPlayer.OnPreparedListener {
    private var mMediaPlayer: MediaPlayer? = null
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        println("inside service oncreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val action:String? = intent!!.action
        //starts the media player
        //lets try to read the intent from MainActivity

        var str =intent!!.getStringExtra("url").toString()  //intent extras is an url
        println(str) //this is the url we want
        println("inside OnstartCommand")
        val url = str //redundant
        when(action){
            "PLAY" ->{
                var intent2 = Intent().also { intent2 ->
                    intent2.setAction("fi.tuni.tamk.disablePlaybutton")

                    sendBroadcast(intent2)
                }
                mMediaPlayer = MediaPlayer()
                mMediaPlayer?.apply{
                    setOnPreparedListener(this@BGMusicService)
                    setAudioAttributes(
                        AudioAttributes.Builder()
                            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                            .setUsage(AudioAttributes.USAGE_MEDIA)
                            .build()
                    )
                    setDataSource(url)
                    prepareAsync()

                    setOnCompletionListener(OnCompletionListener

                    {


                        var intent4 = Intent().also{
                            intent4 -> intent4.setAction("fi.tuni.tamk.songisfinished")
                            sendBroadcast(intent4)
                        }
                    })

                }
            }
            "STOP"->{
                var intent3 = Intent().also { intent3 ->
                    intent3.setAction("fi.tuni.tamk.disableStopbutton")

                    sendBroadcast(intent3)
                }
                mMediaPlayer?.pause()
                //probably a Broadcast needs being implemented to tell ui that button stop is not workinggg
            }
        }
//        val mediaPlayer = MediaPlayer().apply {
//            setAudioAttributes(
//                AudioAttributes.Builder()
//                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
//                    .setUsage(AudioAttributes.USAGE_MEDIA)
//                    .build()
//            )
//            setDataSource(url)
//            prepare() // might take long! (for buffering, etc)
//            start()
//        }
        return START_STICKY
    }


    override fun onPrepared(p0: MediaPlayer?) {
        mMediaPlayer?.start()
    }
    fun  MediaPlayer.OnCompletionListener(m:MediaPlayer?){
        println("track is completed")
    }
}
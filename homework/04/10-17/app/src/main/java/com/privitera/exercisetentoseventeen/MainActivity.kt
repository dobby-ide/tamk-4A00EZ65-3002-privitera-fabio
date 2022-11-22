package com.privitera.exercisetentoseventeen

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.ObjectMapper
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

@JsonIgnoreProperties(ignoreUnknown = true)
data class StarWarsJsonObject(var results: MutableList<Person>? = null)
@JsonIgnoreProperties(ignoreUnknown = true)
data class Person(var name: String? = null, var mass: Int = 0, var height: Int = 0)

class MainActivity : AppCompatActivity() {
    lateinit var textView:TextView
    lateinit var listView:ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView=findViewById(R.id.listView)

    }

    override fun onResume() {
        super.onResume()
        thread() {
            var s :String? = getUrl("https://swapi.dev/api/people/")
          /*  val root = JSONObject(s)
            val array = root.getJSONArray("results")
           println(array.getString(0))
            var root2 = JSONObject(array.getString(0))
            println(root2.getString("name"))
            runOnUiThread{
                textView.text=root2.getString("name")
            }*/

            val mp = ObjectMapper()
            val myObject: StarWarsJsonObject = mp.readValue(s, StarWarsJsonObject::class.java)
            val persons: MutableList<Person>? = myObject.results
            //above code will parse the json correctly so now we have a mutablelist of Persons

            //now, because our data is stored in a mutablelist???? we use arrayadaptor to be able to read that in our UI

            var adapter :ArrayAdapter<Person> =  ArrayAdapter<Person>(this, R.layout.item, R.id.myTextView, ArrayList<Person>());
            runOnUiThread{
                listView.setAdapter(adapter);
                if (persons != null) {
                    for(item in persons){
                        adapter.add(item)
                    }
                }
            }

            persons?.forEach {
                println(it)
            }



        }
    }
    private fun getUrl(url:String):String?{
        var result :String? = null
        val sb = StringBuffer()
        val myUrl = URL(url)
        val conn = myUrl.openConnection() as HttpURLConnection
        val reader = BufferedReader(InputStreamReader(conn.inputStream))
        reader.use{
            var line:String? = null
            do{
                line=it.readLine()
                sb.append(line)

            }while(line!=null)
            result = sb.toString()
        }
        return result
    }
}
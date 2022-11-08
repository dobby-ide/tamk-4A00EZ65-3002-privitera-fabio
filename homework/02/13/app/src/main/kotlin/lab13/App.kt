
package lab13


import java.io.InputStream
import kotlin.concurrent.*
import com.google.gson.Gson;
import java.net.*
import javax.swing.*
import java.awt.event.*
import com.google.gson.annotations.SerializedName




data class PeopleAPI (

  @SerializedName("count"    ) var count    : Int?               = null,
  @SerializedName("next"     ) var next     : String?            = null,
  @SerializedName("previous" ) var previous : String?            = null,
  @SerializedName("results"  ) var results  : ArrayList<Results> = arrayListOf()

)
data class Results (

  @SerializedName("name"       ) var name      : String?           = null,
  @SerializedName("height"     ) var height    : String?           = null,
  @SerializedName("mass"       ) var mass      : String?           = null,
  @SerializedName("hair_color" ) var hairColor : String?           = null,
  @SerializedName("skin_color" ) var skinColor : String?           = null,
  @SerializedName("eye_color"  ) var eyeColor  : String?           = null,
  @SerializedName("birth_year" ) var birthYear : String?           = null,
  @SerializedName("gender"     ) var gender    : String?           = null,
  @SerializedName("homeworld"  ) var homeworld : String?           = null,
  @SerializedName("films"      ) var films     : ArrayList<String> = arrayListOf(),
  @SerializedName("species"    ) var species   : ArrayList<String> = arrayListOf(),
  @SerializedName("vehicles"   ) var vehicles  : ArrayList<String> = arrayListOf(),
  @SerializedName("starships"  ) var starships : ArrayList<String> = arrayListOf(),
  @SerializedName("created"    ) var created   : String?           = null,
  @SerializedName("edited"     ) var edited    : String?           = null,
  @SerializedName("url"        ) var url       : String?           = null

)

fun fetchAndParse(callback:(data:PeopleAPI)->Unit){
    var url:URL = URL("https://swapi.dev/api/people") //one of the many constructors in URL, only a string

    var huc=url.openConnection() as HttpURLConnection //from stackoverflow.com, meaning of "as"??
    huc.setRequestProperty("Accept", "application/json");
    var inputstream = huc.getInputStream() as InputStream;
    val inputAsString = inputstream.bufferedReader().use { it.readText() }
    val gson:PeopleAPI = Gson().fromJson(inputAsString, PeopleAPI::class.java)
    callback(gson)
}
fun main(args: Array<String>) {
    var dataNames:Array<String> = arrayOf()
    var dataBMI:Array<Double> = arrayOf()
    var data1:Array<Array<String>> = arrayOf()
    var columnNames:Array<String> = arrayOf("Name","BMI")

    val b = Thread(Runnable{
        var dataname:MutableList<String> = mutableListOf()
        var databmi:MutableList<Double> = mutableListOf()
        fetchAndParse(){
            for(i in 0..it.results.size-1){
            dataname.add(it.results[i].name!!)
            databmi.add(it.results[i].mass!!.toDouble()/(it.results[i].height!!.toDouble()*it.results[i].height!!.toDouble())*10000)
            }
            }
            dataNames = dataname.toTypedArray()
            dataBMI = databmi.toTypedArray()
            val bmi = dataBMI.map {it.toString()}.toTypedArray()
        data1 = arrayOf(arrayOf(dataNames[0], bmi[0]),arrayOf(dataNames[1], bmi[1]),
        arrayOf(dataNames[2],bmi[2]),arrayOf(dataNames[3], bmi[3]),arrayOf(dataNames[4], bmi[4]),
        arrayOf(dataNames[5],bmi[5]),arrayOf(dataNames[6], bmi[6]),arrayOf(dataNames[7], bmi[7]),
        arrayOf(dataNames[8],bmi[8]),arrayOf(dataNames[9], bmi[9]))


    })
    val a = Thread(Runnable{
        var table = JTable(data1, columnNames);
        val jframe = JFrame()
        val window:JScrollPane = JScrollPane(table);
        jframe.setSize(600,600);
        jframe.getContentPane().add(window);
        jframe.setVisible(true)
        table.setFillsViewportHeight(true);
})

b.start()
b.join()
a.start()
    }


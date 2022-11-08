
package lab012
import java.io.InputStream
import kotlin.concurrent.*
import com.google.gson.Gson;
import java.net.*


data class Luke(
    val name: String,
    val height: String,
    val mass: String,
     var bmi: Double,
    val hair_color:String,
    val skin_color:String,
    val eye_color:String,
    val birth_year:String,
    val gender: String,
    val homeworld: String,
    val films: List<String>,
    val species: List<String>,
    val vehicles: List<String>,
    val starships: List<String>,
    val created: String,
    val edited: String,
    val url: String

    ){

    }
fun fetchAndParse(pageNumber:Int,callback:(data:Luke)->Unit){
    var url:URL = URL("https://swapi.dev/api/people/$pageNumber/") //one of the many constructors in URL, only a string
    var huc=url.openConnection() as HttpURLConnection //from stackoverflow.com, meaning of "as"??
    huc.setRequestProperty("Accept", "application/json");
    println(huc.getInputStream())
    var inputstream = huc.getInputStream() as InputStream;
    val inputAsString = inputstream.bufferedReader().use { it.readText() }
    val gson:Luke = Gson().fromJson(inputAsString, Luke::class.java)
    var heigth=gson.height.toDouble()/100
    var bmi = gson.mass.toDouble()/(heigth*heigth)
    gson.bmi=bmi //not sure if this is the correct way, cant work on the custom class to also achieve the bmi??
    callback(gson)
}
fun main(args: Array<String>) {
    fetchAndParse(args[0].toInt()) {
        println(it.name)  // where it is custom class Person that you will implement
        println(it.bmi)
    }

    }

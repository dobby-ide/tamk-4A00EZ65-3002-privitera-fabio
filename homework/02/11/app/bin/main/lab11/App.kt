package lab11

import java.nio.file.Paths
import java.nio.file.Files
import kotlin.concurrent.*
import com.google.gson.Gson;

fun readFile(fileName: String, encoding: String, returningList:(data:String) -> Unit):String{
    val file = Paths.get(fileName)
    var list: List<String> = Files.readAllLines(file)
    var readFile = ""
    for (i in 0..list.size-1){
        var lines = list[i]
        readFile += lines //not a solution that I like!
    }
    returningList(readFile)
    return readFile

}
data class Luke(
    val name: String,
    val height: String,
    val mass: String,
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
    )
fun main(args: Array<String>) {
    var r: String=""
        thread {
            r = readFile(args[0],"utf-8") {println(it)}

        }
        val gson:Luke = Gson().fromJson(r, Luke::class.java)
       // println("value of r is "+ r)
       var heigth=gson.height.toDouble()/100
        println(gson.mass.toDouble()/(heigth*heigth))
    }

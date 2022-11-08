/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package lab10
import java.nio.file.Paths
import java.nio.file.Files
import java.nio.charset.StandardCharsets;
import kotlin.concurrent.*
import java.io.*
import java.util.*
import java.lang.*;
import java.util.Locale


//READ
//did not manage the encoding part
fun readFile(fileName: String, encoding: String, returningList:(data:String) -> Unit){
    val file = Paths.get(fileName)
    var list: List<String> = Files.readAllLines(file)

    for (i in 0..list.size-1){
        var lines = list[i]
        returningList(lines)
    }
}
//SAVE
//unsure if Unit needs being used here.........!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
fun saveFile(fileName:String, content:MutableList<String>, encoding:String, callback:(bool:Boolean)-> Unit){
    if(Files.exists(Paths.get(fileName))){
        callback(false)
    }else{
        callback(true)
    }
    var filecontent: String = ""
    for(i in content){
        filecontent += i
    }

    Files.write(Paths.get(fileName), filecontent.toByteArray());


}


fun main(args: Array<String>) {
    if(args.size>0){
        val fileContent:MutableList<String> = mutableListOf()
        thread {

            readFile(args[0],"utf-8") {println(it);fileContent.add(it)}
        }

    thread{

        saveFile(args[1], fileContent, "utf-8") {
        println(if(it) "success" else "problem")
            }
        }
    }
}

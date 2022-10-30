import java.nio.file.Paths
import java.nio.file.Files

fun main(arguments: Array<String>){


    val file = Paths.get(arguments[0])
    val file2 = Paths.get(arguments[1])
    var list: List<String> = Files.readAllLines(file)
    var list2: List<String> = Files.readAllLines(file2)

    for(i in list){
        // i.indexOf("\t") always returns -1, that is why I have used 8 spaces to emulate a tab
        if(i.contains("        ")){
            var str : String=i.replace("        ", "____")
            println(str)
        }

    }
    for(i in list2){
        // i.indexOf("\t") always returns -1, that is why I have used 8 spaces to emulate a tab
        if(i.contains("        ")){
            var str : String=i.replace("        ", "____")
            println(str)
        }

    }
}
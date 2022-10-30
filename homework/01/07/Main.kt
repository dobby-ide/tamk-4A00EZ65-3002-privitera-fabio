fun generateRandomBoolean() : Boolean {
    return (0..1).random() == 0;


}
class Person {
    val computer : Computer? = if (generateRandomBoolean()) Computer() else null
}

class Computer {
    val display : Display? = if (generateRandomBoolean()) Display() else null
}

class Display {
    val usbc : UsbC? = if (generateRandomBoolean()) UsbC() else null
}

class UsbC {
    val speed : Int = if (generateRandomBoolean()) 20 else 40
}

fun main(){
    val jack = Person()
    //a
    if(jack.computer != null){
        println("computer is not null")
        if(jack.computer.display!= null){
            println("display is not null")
            if(jack.computer.display.usbc != null){
                println("usbc is not null")
                println(jack.computer.display.usbc.speed)
            } else{
                println("usbc is null")
            }
        }
    }
    //b
    println(jack.computer?.display?.usbc?.speed);
    //c
    println(jack.computer!!.display!!.usbc!!.speed);
    //d
    println(jack.computer?.display?.usbc?.speed ?: "nope")

}







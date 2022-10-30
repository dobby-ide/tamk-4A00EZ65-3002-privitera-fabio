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

fun validate(args: Array<String>) : Int?{
    var valueInArgs : Int = 0
    if(args.size<=0){
        return null
    }else{
        valueInArgs = args[0].toInt();
        }
    return valueInArgs

}

fun createList(numberOfPersons: Int) : MutableList<Person>{
    val list = mutableListOf<Person>()
    for(i in 0..numberOfPersons -1){
        list.add(Person())
    }
    println(list.size)
    return list
}

fun output (listOfPerson : MutableList<Person>) : Unit{
    for (i in 0 until listOfPerson.size) {
        var jack = listOfPerson[i].computer?.display?.usbc?.speed
        if(jack != null){
            println(jack)
        } else{
            println("could not fetch the speed")
        }
    }
}
fun main(args: Array<String>) {
    val numberOfPersons : Int? = validate(args)
    if(numberOfPersons != null) {
    val listOfPersons : MutableList<Person> = createList(numberOfPersons)
    output(listOfPersons)
    } else {
        println("please give integer > 0")
    }
}
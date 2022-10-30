
fun main() {
    println("give a string: ")
    var str: String? = readLine()
    println("give a number: ")
    var num: String? = readLine()
    //var value2 : Int = if (num != null) num.toInt() else -1  //this is now an Int so it does not allow String, nor is possible to have a null value in here anyway!!!????
    //var value3 : Int? = if (num != null) num.toIntOrNull() else -1
    val value4 : Int? = num?.toIntOrNull()
    var amount : Int = 0;
    if(value4 != null){
        amount = value4;
    }
    for(i in 1..amount-1) print(str)
    println(str)

    println(amount)

}
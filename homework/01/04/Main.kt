


fun main() {
    println("is it palindrome? Enter a word: ")
    val console = System.console()
    val readText = console.readLine()
    var reverse : String = ""
    for (i in readText.length-1 downTo 0){
        var t : Char = readText[i].toChar()
        reverse += t
    }

    if(readText == reverse){
        println("it is palindrome")
    }else{
        println("not palindrome")
    }

}
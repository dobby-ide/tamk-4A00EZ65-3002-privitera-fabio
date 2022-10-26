

import java.time.LocalDate




fun main(args: Array<String>){
    var localDate = LocalDate.now();
    var monthValue : Int = localDate.getMonthValue()
    var leapYear : Boolean = localDate.isLeapYear
    when (monthValue) {
    1 -> print("31")
    2 -> if (leapYear) {
                print("29")
        } else {
                print("28")
        }
    3 -> print("31")
    4 -> print("30")
    5 -> print("31")
    6 -> print("30")
    7 -> print("31")
    8 -> print("31")
    9 -> print("30")
    10 -> print("31")
    11 -> print("30")
    12 -> print("31")


}

}
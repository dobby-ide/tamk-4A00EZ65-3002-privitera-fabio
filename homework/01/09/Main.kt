fun sum(num1:Int, num2:Int, callback:(data: Int) -> Unit):Int{
    callback(num1+num2);
    return num1 + num2
}


fun isPositive(a: Int, success: () -> Unit, fail: () -> Unit) {
    if(a > 0) {
        success()
    } else{
        fail()
    }
}

fun main() {
    sum(4, 5, {msg -> println(msg)})
    //with trailing lambda
    sum(2,3) {msg -> println(msg)}
    //with "it"
    sum(2,3) {println(it)}
    // isPositive(-1) { println("success")}
    // isPositive(3) { println("success")}

    isPositive(2,  {println("success")},  {println("fail")})
    isPositive(-9 ,{println("success")}) {println("fail")}
}
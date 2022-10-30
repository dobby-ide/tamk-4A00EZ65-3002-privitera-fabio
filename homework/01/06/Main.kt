fun createStock (company : String) : String?{
    if(company == "Microsoft"){
        return "MSFT"
    } else if (company == "Nokia"){
        return "NOK"
    } else if (company == "Apple"){
        return "APPL"
    } else {
        return null;
    }
}


fun main(){
    println("give a company name: ")
    var input = readLine()
    val stock : String? = createStock(input.toString())
    println(stock?.lowercase())

}
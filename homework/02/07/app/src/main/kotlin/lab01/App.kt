package lab01

fun main(){}


/**
 * Searches the array for searchValue. Returns the first index where searchValue
 * is found. If not found, returns null.
 *
 * @param args array to be searched
 * @param searchValue value to be searched for
 * @return either index or null depending if searchValue was found
 */
fun search(args: Array<Int>, searchValue: Int) : Int? {
    for(i in 0..args.size -1){
        if(args[i]==searchValue){
            return i
        }
    }
   return null
}
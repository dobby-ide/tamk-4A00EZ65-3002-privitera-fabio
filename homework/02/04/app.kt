import kotlin.random.Random

data class Person(var name : String, var age : Int){

}

fun main(arguments: Array<String>){
	val max = arguments[0].toInt()
	var personsList: MutableList<Person> = mutableListOf<Person>()
	val namesArray = arrayOf("Hannah", "Jack", "Tina")

	for (i in 1..max){
		val rnds = (1..100).random()
		val randomIndex = Random.nextInt(namesArray.size);
    	val randomName: String = namesArray[randomIndex]

	   personsList.add(Person(randomName, rnds))
	}
	println(personsList)
	println("---------------------DISTINCT----------------")
	println(personsList.distinct())
	//if class is not a data class then distinct is harder to be succesful since all the objects created will have unique reference and cant be found equals // not sure, just guessing
}
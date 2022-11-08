open class Person(var name:String){
	// init{
	// 	println(name)
	// }
	fun sleep() = println(this.name + " sleeps")
	open fun drink() = println(this.name + " drinks water")
	override fun toString() : String{
		if(this is Programmer){
			return "name = " + this.name + " and salary = " + this.salary
		}
		return "name = " + this.name
	}
}

class Programmer(name:String, salary: Int):Person(name){
	var salary: Int = salary
		get() = field
		set(value){
			if(value < 0){
				throw IllegalArgumentException()
			} else {
				field = value;
			}
		}


	init{
		if(this.salary<0){
			throw IllegalArgumentException()
		}



	}
	override fun drink() = println(this.name + " drinks energy drink")
	fun codeApps() = println(this.name + " code apps")

}

fun main() {
	// val frank = Programmer("mario")
    val tina = Programmer("tina", 4000)
	//uses salary getter
	println(tina.salary)

	//uses salary setter
	tina.salary = 3999
	println(tina.salary)
	//crashes the app -> IllegalArgumentException
	tina.salary = -1

    // outputs "tina drinks energy drink"

    tina.drink()
    // "tina sleeps"
    tina.sleep()
    // "tina code apps"
    tina.codeApps()
    // "name = tina, salary = 4000"
    println(tina.toString())

    val jack = Person("jack")
    // "jack drinks water"
    jack.drink()
    // "jack sleeps"
    jack.sleep()
    // "name = jack"
    println(jack.toString())
}
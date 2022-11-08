//according to the Kotlin documentation, only the variables in constructors are used when creating
//adhoc toString, equals, hashCode, copy?? methods.


data class Person(var name : String, var age : Int){
	//copy function allows to reassign to a new object the existing properties of another object plus modifying those.
	//fun copy(name: String = this.name, age: Int = this.age) = Person(name, age)
}

fun main(){
	val jack1 = Person("jack", 30)
	val jack2 = Person("jack", 30)
	//difference is that now the compiler has generated for us all the POJO/boiler plate code because of adding data in before class keyword, including overriding Any methods
	println(jack1.toString()) //-> Person(name=jack, age=30)
	println(jack2.toString()) //-> Person(name=jack, age=30)
	println(jack1.equals(jack2)) // true
	println(jack1.hashCode()) //-> 100881439
	println(jack2.hashCode()) //-> 100881439
	//copy functionalities as follow:
	val mike = Person("Mike", 22)
	val newMike = mike.copy("Mikey")
	println(newMike)
}
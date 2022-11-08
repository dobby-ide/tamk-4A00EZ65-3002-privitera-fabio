
class Person(var name : String, var age : Int)
fun main(){
	val jack1 = Person("jack", 30)
	val jack2 = Person("jack", 30)
	//default toString() returns the hashcode in String format
	//default implementation being as follow in Java, supposedly being similar in Kotlin:
		// 	public String toString() {
		//       return getClass().getName()+"@"+Integer.toHexString(hashCode());
		// }  reference: https://www.geeksforgeeks.org/object-tostring-method-in-java/
	println(jack1.toString()) // Person@hashCode() -> Person@4b85612c
	println(jack2.toString()) // Person@hashCode() -> Person@277050dc
	//equals method returns Boolean true if the object compared returns in turn the same hashCode values:

	println(jack1.equals(jack2)) //false, hashCode is different
	//however when comparing members variables we can determine that String class has overriden the equals method
	// and since Kotlin does not hold primitive types, that happens also for Integer, Char and so on..
	println(jack1.name.equals(jack2.name)) //true, equals is overriden
	println(jack1.age.equals(jack2.age)) //same as above
	}
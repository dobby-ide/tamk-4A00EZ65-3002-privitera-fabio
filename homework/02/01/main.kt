class Circle (var radius: Int, var color: String?) {

	fun printSurfaceArea() = println(radius*radius*kotlin.math.PI)

	// fun attributesToString() = "radius = " + radius + ", color = " + color
	fun attributesToString() = if(color!=null) "radius = " + radius + ", color = " + color else "radius = " + radius

	constructor(radius: Int) : this(radius , null) {
	}
}

fun main(){
val c = Circle(radius = 5, color = "red")
println(c.radius)      // 5
c.printSurfaceArea()   // outputs the surface area of the circle, 78.53981633974483
println(c.attributesToString())  // radius = 5, color = red


val c1 = Circle(radius = 5, color = "red")
val c2 = Circle(radius = 5)
println(c1.attributesToString() +", " + c2.attributesToString())

}


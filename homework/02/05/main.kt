import kotlin.random.Random
interface Drawable {
    fun draw()
}

data class Rectangle(var width: Int, var height: Int):Drawable{
	override fun draw(){
		for(i in 1..height){
			println()
			for(j in 1..width){
				print("X")
			}
		}
		println()
	}
}
data class RectTriangle(var height: Int):Drawable{
	override fun draw(){
		var count: Int = 0
		for(i in 1..height){
			count++
			println()
			for(j in 1..count){
			print("X")
			}

		}
		println()
	}
}
fun generateRandomArray(amount: Int): MutableList<Drawable>{
	var listOfDrawable : MutableList<Drawable> = mutableListOf()
	for(i in 1..amount){
		var random = (1..2).random()
		var randomHeight = (3..5).random()
		var randomWidth = (3..5).random()
		when(random){
			1 -> listOfDrawable.add(Rectangle(randomWidth,randomHeight))
			2 -> listOfDrawable.add(RectTriangle(randomHeight))
		}
	}



	return listOfDrawable
}
fun main(){
	// var shape1 = Rectangle(2,4);
	// shape1.draw()
	// var shape2 = RectTriangle(4)
	// shape2.draw()
	val drawables : MutableList<Drawable> = generateRandomArray(amount = 5)
	for (i in drawables){
		i.draw()
	}
}
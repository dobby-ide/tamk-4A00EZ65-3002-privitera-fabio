class Mammal {
	var weight: Double = 0
}


class Dog : Mammal {
	var name : String?
	func bark() {
		if let x = name {print(String(x),"barking")} else {print("barking")}
	}
}


func main() {
    let spot = Dog()
	spot.name = "Spot"
    spot.weight = 50
    spot.bark()
}
main()
//12

class Human : Mammal {
	var name : String?
	func createArt(){
		if let x = name {print(String(x),"creates art")} else {print("creates art")}
	}
}


// let tina = Human()
// tina.name = "tina"
// tina.weight=99
// tina.createArt()

//13
func printWeight(mammal: Mammal) -> Void {
	print(mammal.weight)
}
let spot = Dog()
	spot.name = "Spot"
    spot.weight = 50

let tina = Human()
tina.name = "tina"
tina.weight=99

printWeight(mammal: spot)
printWeight(mammal: tina)
//14
func useMethod(mammal: Mammal) -> Void {
	if mammal is Dog {
		let mammalObj = mammal as? Dog
		mammalObj!.bark()
	} else if mammal is Human {
		let mammalObj = mammal as? Human
		mammalObj!.createArt()
	}
	// let mammalObj2 = mammal as? Dog
	// mammalObj != nil ? mammalObj!.createArt() : print("it is nil")
	// mammalObj2 != nil ? mammalObj!.bark() : print("it is nil")
}

useMethod(mammal: spot)
useMethod(mammal: tina)

//15
class Person {
	// var name : String = ""
	// var age : Int = 0
	// var name : String?
	// var age : Int?
	var name : String
	var age : Int

	init () {
		name = ""
		age = 0
	}



}

//var jackie = Person() fails because no initializing in members
var jackie = Person()


class PersonD {
    var name : String?

 init(name: String) {
        self.name = name
    }
}
// class Programmer : PersonD {
//     private var salary : Int?
//     init(name: String, salary : Int) {
// 		super.init(name: name)
//         self.salary = salary
//     }
// }
// var jack = Programmer(name: "jack", salary: 4000)

//17
class Programmer : PersonD {
    var salary : Int?
	var anotherv: Int?
    init(name: String, salary : Int) {
		self.salary = salary
		super.init(name: name)
    }
	override convenience init(name:String){
		self.init(name:name, salary:4000)
	}
	convenience init(){
		self.init(name:"TINA", salary:4000)
	}
}
var mark = Programmer(name:"Mark")
print(mark.salary)
print(mark.name)
var tinaaa = Programmer()

print(tinaaa.name)
print(tinaaa.salary)
//18 ?????????????


class PersonE {
   var name : String = ""
   var age : Int = 0
	init(){
		print("person created")
	}

	convenience init(name: String, age: Int) {
		self.init(name:"Tina", age:44)
	}
}

class ProgrammerA : PersonE {
}

var jack = ProgrammerA()//shows same init

print(jack.name)
var  t = PersonE()
print(t.name)

//19

class Point {
    var x : Int
    var y : Int

init(x: Int, y: Int) {
	self.x = x
	self.y = y
	}
	convenience init(){
		self.init(x:0,y:0)
	}

}


class Pixel : Point {
    var color : String

init(x: Int, y: Int, color: String) {
        self.color = color
        super.init(x: x, y: y)
		//self.x=0
    }
}
// Designated init
let p2 = Point(x: 1, y: 2)
// Convenience init
let p1 = Point() // x = 0, y = 0
//20
//after super call

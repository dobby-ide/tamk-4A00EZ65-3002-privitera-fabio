class PointC {
	var x : Int = 0
	var y : Int = 0
}

struct PointS : Equatable {
	var x : Int = 0
	var y : Int = 0

	// static func == (left: PointS, right: PointS) -> Bool {
	// 	return (left.x == right.x)
	// }
}


let a = PointC()
let b = PointS()


var referenceA = a
var copyB = b
referenceA.x = 1
print(a.x) // each instance share the data (REFERENCE TYPE)
copyB.x = 1
print(b.x) // each instance have their own data stored separately (VALUE TYPE)

let test1 = PointS(x: 0, y: 1)
//let test2 = PointC(x: 0, y: 1) not possible, it means faster implementation when using structs???


let aa = PointC()
let bb = PointC()
print(aa === bb) //false


let aaa = PointC()
let bbb = aaa
print(aaa === bbb)

//with structs

// let x = PointS()
// let j = PointS()
// print(x === j) //error-> expects to be an instance of a class, must have something to do with ===


let xx = PointS(x: 1, y: 8)
let yy = PointS(x: 0, y: 9)
print(xx == yy)

class PointClass : Equatable {
	var x : Int = 0
	var y : Int = 0
	static func == (left: PointClass, right: PointClass) -> Bool {
		return (left.x == right.x)
	}

}
let abc = PointClass()
abc.x = 1

let def = PointClass()
def.x=1
print(abc == def)

////////////////////////////////////////////

struct Circle {
	private var _radius: Double?
	var radius: Double? {
		get{
			return _radius
		}
		set(newRadius){
			if(newRadius! < 0){
				_radius = 0
			}
			_radius = newRadius
		}
	}
	var surfaceArea : Double {
		get{
			return radius!*radius!*3.14
		}
		set{
			radius!*radius!*3.14
		}
	}
}
var circle = Circle()
circle.radius = 2
print(circle.surfaceArea)
// let circle = Circle(radius:2.2)
// print(circle.surfaceArea)



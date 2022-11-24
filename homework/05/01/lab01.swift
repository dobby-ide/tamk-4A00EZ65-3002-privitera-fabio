var x : Int  //var is mutable
let y : Double //let is a constant

print(type(of:x))
print(type(of:y))

var 🙂: Float
print(type(of:🙂))
x=2
y=2.222
//implements own + function
// func + (d:Double,i:Int)->Double{
// 	return d+Double(i)
// }

//var sum = y + Double(x)
var sum = y + Double(x)
print(sum)

let car: (engineNumber:Int, maxSpeed:Double) = (345,200.5)
print(car.0)
print(car.1)
let(a,b)=car
print(a)
let(_,c)=car
print(c)
print(type(of:car))


let contact :(String,(String,String,Int,String)) = (name:"Jack",address:(line:"Hameenkatu",city:"Tampere",zip:33100,country:"Finland"))

let (aa, (cc,dd,ee,ff)) = contact
print(ee)

//Working with Int
let z :Int = -7
var zz :Int {
	return 8
}
print(z.distance(to:zz))
print(Int.min)
print(UInt8.max)
//just a generic function
var z_abs: Int{
	abs(-7)
}


print(z_abs)



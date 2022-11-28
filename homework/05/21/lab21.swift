//enum declaration and case study

// enum Color: Int {
// 	case white = 12, red, yellow, blue, green
//  }
// let y = Color.red
// let x = Color.white
// print(x)
// print(x.rawValue) //12
// print(y.rawValue) //13

//enum error handlings


enum MathCalculationError: Error {
    case cannotDivideWithZero
}

func division(n numerator: Int, d denominator: Int) throws -> Int {
  if denominator == 0 {
    throw MathCalculationError.cannotDivideWithZero
  }
  return numerator / denominator

}

let x: Int = try! division(n:2,d:2)

do {
  try z = division(n: 10, d: 0)
  print("Valid Division")
}

catch MathCalculationError.cannotDivideWithZero {
  print("Error: Denominator cannot be 0")
}
var z: Int

do{
	try z = division(n: 2, d: 0)
	print("VALID")
}
catch  MathCalculationError.cannotDivideWithZero {
	print("error: Denominator cannot be 0")
}


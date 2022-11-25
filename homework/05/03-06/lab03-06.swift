//FUNCTIONS
		//03
// func findIndArray(arrayToBeSearchedFrom arrayofInt:[Int],valueToBeSearched value:Int = 0)->Int?{
// 	for index in 0..<arrayofInt.count {
// 		//print("\(index)")
// 		if arrayofInt[index] == value{
// 			return index
// 		}
// 	}
// 	// if let value = arrayofInt.firstIndex(of:valueToBeSearched){
// 	// 	return value
// 	// }else{
// 	// 	return nil
// 	// }
// 	return nil
// }

// let value1 = findIndArray(arrayToBeSearchedFrom: [2,3,0,4])
// let value2 = findIndArray(arrayToBeSearchedFrom: [0,2,3,4], valueToBeSearched: 4)
// print(value1!)  // 1
// print(value2!)  // 3


		//04
// func findInArray(arrayToBeSearchedFrom arrayofInt:[Int],valueToBeSearched value:Int = 0, success:(Int) -> Void, fails:(String) -> Void )-> Void{
// 	var check : Bool=false
// 	var numberToReturn: Int = -1
// 	for index in 0..<arrayofInt.count {

// 		if arrayofInt[index] == value{
// 			check=true
// 			numberToReturn = index
// 		}
// 	}
// 	if(check){
// 		success(numberToReturn)

// 	}else{
// 		fails( "Could not find value \(value)")
// 	}


// }

// func success(number : Int) -> Void{
// 	print(number)
// }

// func fails(message : String) -> Void {
// 	print(message)
// }

// findInArray(arrayToBeSearchedFrom: [0,2,3,4], valueToBeSearched: 2, success: success, fails: fails)

// findInArray(arrayToBeSearchedFrom: [0,2,3,4], valueToBeSearched: -2, success: success, fails: fails)

// func findInArray(arrayToBeSearchedFrom arrayofInt:[Int],valueToBeSearched value:Int = 0, success:(Int) -> Void, fails:(String) -> Void )-> Void{
// 	var check : Bool=false
// 	var numberToReturn: Int = -1
// 	for index in 0..<arrayofInt.count {

// 		if arrayofInt[index] == value{
// 			check=true
// 			numberToReturn = index
// 		}
// 	}
// 	if(check){
// 		success(numberToReturn)

// 	}else{
// 		fails( "Could not find value \(value)")
// 	}


// }

// findInArray(arrayToBeSearchedFrom: [0,2,3,4], valueToBeSearched: 3, success:{
// 	(msg:Int) -> Void in print(msg)
// }, fails:{(msg:String) -> Void in print(msg)})

// findInArray(arrayToBeSearchedFrom: [0,2,3,4], valueToBeSearched: 21,success:{(msg:Int) -> Void in print(msg)}){
// 	print($0)

// }
		//05

// struct Person {
//     var age : Int = Int.random(in: 1...100)
// }
// var persons : [Person] = []
// for _ in 1...20 {
//     persons.append(Person())
// }
// persons.sort{
// 	$0.age>$1.age
// }
// print(persons)

// var ages : [Int] = persons.map{
// 	$0.age
// }
// print(ages)

		//06

extension Int {
    func hello() {
        print("moro")
    }
}
4.hello()
//the only reason why this works is that task() directly refers to a function that will be passed in repeats extension (as a trailing lamba, closure that is)
extension Int {
	func repeats(task:() -> Void) {
		for _ in 0..< self{
		task()
		}
	}
}

3.repeats() {
   print("hello")
}
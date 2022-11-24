//OPTIONALS
     //a)
var userInput1:String? = readLine()
var userInputToInt1 = Int(userInput1!)
var userInput2:String? = readLine()
var userInputToInt2 = Int(userInput2!)
//HARD-WRAP
var sum = userInputToInt1! + userInputToInt2!
print(sum)
//CONDITIONAL UNWRAPPING
if let anotherVariable = userInputToInt1 , let anotherVariable2 = userInputToInt2 {
	print(anotherVariable + anotherVariable2)
}
    //b)


struct Person {
    // initializes computer to Computer() object or nil
    var computer : Computer? = Bool.random() ? Computer() : nil
}

struct Computer {

	var soundCard : SoundCard? = Bool.random() ? SoundCard() : nil
}

struct SoundCard {

	var name : String? = Bool.random() ? "SoundBlaster" : nil
}
let jack = Person()
if let x = jack.computer?.soundCard?.name{
	print(x)
}
// print(jack.computer!.soundCard!.name!)
import kotlin.random.Random
import java.util.ArrayList
fun main(arguments:Array<String>){
	//INITIALIZE lotto Numbers
	var lottoNumbers : MutableList<String> = mutableListOf("01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40")

    //INSIDE GAME FUNCTIONS
	fun gameOfLotto():Int{
		var totalGuess = 0
		var countGuess = 0
		while(countGuess<7){
			var chosenNumbers : MutableList<String> = mutableListOf()
		while(chosenNumbers.size<7){
			val rn = Random.nextInt(39)
			if (!chosenNumbers.contains(lottoNumbers[rn])){
				chosenNumbers.add(lottoNumbers[rn])
				}
			}

		chosenNumbers.sort();

		countGuess = 0
		for(i in chosenNumbers){
			for(j in arguments){
				if(i.equals(lottoNumbers[j.toInt() - 1])){
					countGuess++

				}
			}
		}

		totalGuess += countGuess;
		print(chosenNumbers)

		println("  ->> correct " + totalGuess)

		return countGuess;
	}
	println(countGuess)
	println(totalGuess)
	return countGuess;

	}
	var n = 0
	var time = 0.00

	var highscore = 0
	while(n < 7){
		time++
		var years: Double = (time/52).toDouble();
		var year = Math.round(years * 100.0) / 100.0
		n = gameOfLotto()
		if(n==1 && highscore <1){
			highscore = 1
			println("correct 1 number and it took " + year + " years")
			n=gameOfLotto()
		}
		else if(n==2 && highscore <2){
			highscore = 2
			println("correct 2 numbers and it took "+ year + " years")
		}
		else if(n==3 && highscore < 3){
			highscore = 3
			println("correct 3 numbers and it took "+ year + " years")
		}
		else if(n==4 && highscore < 4){
			highscore = 4
			println("correct 4 numbers and it took "+ year + " years")
		}
		else if(n==5 && highscore < 5){
			highscore = 5
			println("correct 5 numbers and it took "+ year + " years")
		}
		else if(n==6 && highscore < 6){
			highscore = 6
			println("correct 6 numbers and it took "+year + " years")
		}
		else if(n==7 && highscore < 7){
			highscore = 7
			println("jackpot!!, and it took " + year + " years")
		}
	}
	println(n)
	}




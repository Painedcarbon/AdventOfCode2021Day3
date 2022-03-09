import java.io.File

fun main(){
    
    /** https://adventofcode.com/2021/day/3 */
    val input = File("input.txt").readLines()
    //part1(input)
    part2(input)

}
fun part1(input: List<String>) {


    var count0 = 0
    var count1 = 0
    var mostSign = ""
    var leastSign = ""

    val stringLength = 11

    for (i in 0 .. stringLength) {

        input.forEach { line->
            println(line)

            if (line[i].equals('0')){
                count0++
            }else {
                count1++
            }

            println("0: $count0 1: $count1")

        }
        if( count0 > count1){
            mostSign += "0"
            leastSign += "1"
        } else {
            mostSign += "1"
            leastSign += "0"
        }
        count0 = 0
        count1 = 0
    }
    println(mostSign)
    println(leastSign)

    val most = Integer.parseInt(mostSign,2)
    val least = Integer.parseInt(leastSign,2)
    println("Most: $most")
    println("Least: $least")

   println("Multiplied: ${most*least}")
}

fun part2(input: List<String>) {
    var inputWithMost = input
    var inputWithLeast = input
    //var input = File("test.txt").readLines()
    //var input2 = File("test.txt").readLines()
    println(inputWithMost)
    var count0 = 0
    var count1 = 0


    val stringLength = 11

    //var stringLength = 4

    /** Innehåler flest*/
    for (i in 0 .. stringLength) {

        inputWithMost.forEach { line->
            println(line)

            if (line[i].equals('0')){
                count0++
            }else {
                count1++
            }

            println("c0: $count0 - c1: $count1 at index: $i")
        }
        if(count0 > count1){
            inputWithMost = inputWithMost.filter { it[i] == '0' }
        } else {
            inputWithMost = inputWithMost.filter { it[i] == '1' }
        }
        println("---------")
        println("Kvar i listan: ${inputWithMost.size}")
        println("---------")
        count0 = 0
        count1 = 0
    }

    /** Innehåller minst*/
    for (i in 0 .. stringLength) {

        inputWithLeast.forEach { line->
            println(line)

            if (line[i].equals('0')){
                count0++
            }else {
                count1++
            }

            println("c0: $count0 - c1: $count1 at index: $i")
        }
        if(count1 >= count0){
            inputWithLeast = inputWithLeast.filter { it[i] == '0' }
        } else {
            inputWithLeast = inputWithLeast.filter { it[i] == '1' }
        }
        println("---------")
        println("Kvar i listan nr 2: ${inputWithLeast.size}")
        println(inputWithLeast)
        println("---------")
        count0 = 0
        count1 = 0
        if (inputWithLeast.size == 1) break
    }

    println("Vinnaren med flest: $inputWithMost")
    println("Vinnaren med minst: $inputWithLeast")

    val binary1 = Integer.parseInt(inputWithMost[0],2)
    val binary2 = Integer.parseInt(inputWithLeast[0],2)

    println("binary1: $binary1 och binary2: $binary2")
    println("svaret ${binary1*binary2}")
}
package weektwo

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    var rightPosition = 0
    var wrongPosition = 0
    var guessMutable = guess
    var secretMutable = secret
    var index: Int
    for (i in secretMutable.indices) {
        if (guessMutable[i] == secretMutable[i]) {
            rightPosition++
            guessMutable = guessMutable.substring(0, i) + guessMutable[i].toLowerCase() + guessMutable.substring(i + 1)
            secretMutable = secretMutable.substring(0, i) + secretMutable[i].toLowerCase() + secretMutable.substring(i + 1)
        }
    }

    for (i in guessMutable.indices) {
        if (secretMutable.contains(guessMutable[i]) &&
            guessMutable[i] != secretMutable[i]) {

            wrongPosition++
            index = secretMutable.indexOf(guessMutable[i])
            secretMutable = secretMutable.substring(0, index) + secretMutable[index].toLowerCase() + secretMutable.substring(index + 1)
        }
    }
    return Evaluation(rightPosition, wrongPosition)
}
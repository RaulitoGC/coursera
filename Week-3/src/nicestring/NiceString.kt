package nicestring

fun String.isNice(): Boolean {

    if(isNullOrEmpty()) return false

    var conditions = 0

    fun notContainsBuBaBe(): Boolean = (!contains("bu") &&
            !contains("ba") &&
            !contains("be"))

    fun containsVowels(): Boolean {
        var count = 0
        this.forEach {
            if (it == 'a' || it == 'e' || it == 'i' || it == 'o' || it == 'u') {
                count++
            }
        }
        return count >= 3
    }

    fun containsDoubleLetters(): Boolean {
        var letter = get(0)
        for (i in 1 until length) {
            if (get(i) == letter) return true
            letter = get(i)
        }
        return false
    }

    if (notContainsBuBaBe()) conditions++
    if (containsVowels()) conditions++
    if (conditions == 2) return true
    else if (containsDoubleLetters()) conditions++

    return conditions >= 2
}
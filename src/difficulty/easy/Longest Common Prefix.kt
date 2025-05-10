package difficulty.easy

/**
 * [Самый длинный общий префикс](https://leetcode.com/problems/longest-common-prefix/description/)
 *
 * Дан массив строк strs, найдите и верните самую длинную общую префиксную строку среди этого массива строк.
 *
 * Если общего префикса нет, верните пустую строку "".
 *
 * @param str Array<String>
 *
 * @return String
 *
 *
 */
fun longestCommonPrefix(strs: Array<String>): String {
    var prefix = ""
    var counter = 0
    var condition = true
    var symbolIndex = 0
    var symbol = ' '
    if (!strs[0].isBlank()) {
        symbol = strs[0][0]
    } else return ""
    while (condition) {
        for (i in 0..strs.size - 1) {
            if (!strs[i].isBlank()) {
                if (symbolIndex <= strs[i].length - 1 && strs[i][symbolIndex] == symbol) {
                    counter++
                } else return prefix
            } else return prefix
        }
        if (counter == strs.size) {
            prefix += symbol
            symbolIndex++
            if (symbolIndex <= strs[0].length - 1)
                symbol = strs[0][symbolIndex]
            else return prefix
            counter = 0
        } else
            condition = false
    }

    return prefix
}

fun main() {
    val strs = arrayOf("a", "ca")
    print(longestCommonPrefix(strs))
}
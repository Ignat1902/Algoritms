/**
 * [Преобразование римского числа в целое](https://leetcode.com/problems/roman-to-integer/description/)
 *
 * Дано римское число, преобразуйте его в целое число.
 *
 * @param s String
 * @return Int
 *
 *
 */
fun romanToInt(s: String): Int {
    val map: HashMap<Char, Int> =
        hashMapOf(
            ('I' to 1),
            ('V' to 5),
            ('X' to 10),
            ('L' to 50),
            ('C' to 100),
            ('D' to 500),
            ('M' to 1000)
        )
    var counter = s.length - 1
    var result = 0
    while (counter >= 0) {
        if (counter == 0) {
            result += map[s[0]]!!
            counter--
        } else {
            when (s[counter]) {
                'V' -> {
                    if (s[counter - 1] == 'I') {
                        result += 4
                        counter -= 2
                    } else {
                        result += map[s[counter]]!!
                        counter--
                    }
                }

                'X' -> {
                    if (s[counter - 1] == 'I') {
                        result += 9
                        counter -= 2
                    } else {
                        result += map[s[counter]]!!
                        counter--
                    }
                }

                'L' -> {
                    if (s[counter - 1] == 'X') {
                        result += 40
                        counter -= 2
                    } else {
                        result += map[s[counter]]!!
                        counter--
                    }
                }

                'C' -> {
                    if (s[counter - 1] == 'X') {
                        result += 90
                        counter -= 2
                    } else {
                        result += map[s[counter]]!!
                        counter--
                    }
                }

                'D' -> {
                    if (s[counter - 1] == 'C') {
                        result += 400
                        counter -= 2
                    } else {
                        result += map[s[counter]]!!
                        counter--
                    }

                }

                'M' -> {
                    if (s[counter - 1] == 'C') {
                        result += 900
                        counter -= 2
                    } else {
                        result += map[s[counter]]!!
                        counter--
                    }
                }
                else -> {
                    result += map[s[counter]]!!
                    counter--
                }
            }
        }

    }
    return result
}

fun main() {
    val roma = "III"
    val res = romanToInt(roma)
    print(res)
}
package difficulty.easy

import java.util.Stack

/**
 * [Правильная скобочная последовательность](https://leetcode.com/problems/valid-parentheses/description/)
 *
 * Дана строка s, содержащая символы '(', ')', '{', '}', '[' и ']', определите, является ли строка валидной.
 *
 * Входная строка валидна, если:
 *
 * 1. Открывающая скобка закрыта скобкой того же типа.
 * 2. Открывающие скобки закрыты в правильном порядке.
 * 3. Каждой закрывающей скобке соответствует открывающая скобка того же типа.
 *
 * @param s String
 *
 * @return Boolean
 *
 *
 */
fun isValid(s: String): Boolean {
    val stack: Stack<Char> = Stack<Char>()

    for (i in s) {
        if (i.code == 123 || i.code == 91 || i.code == 40) {
            stack.push(i)
        } else {
            if (!stack.isEmpty()) {
                val topElementInStack = stack.peek()
                when (i) {
                    ')' -> {
                        if (topElementInStack == '(') {
                            stack.pop()
                        } else return false
                    }

                    ']' -> {
                        if (topElementInStack == '[') {
                            stack.pop()
                        } else return false
                    }

                    '}' -> {
                        if (topElementInStack == '{') {
                            stack.pop()
                        } else return false
                    }
                }
            } else return false

        }
    }

    return stack.isEmpty()
}

fun main() {
    val s = "{{{[}}}"
    val result = isValid(s)
    print(result)
}

/*
{ - 123
} - 125
[ - 91
] - 93
( - 40
) - 41
 */

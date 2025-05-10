package difficulty.easy

/**
 * [Сумма двух](https://leetcode.com/problems/two-sum/description/)
 *
 * Даны массив целочисленных значений nums и целое число target, верните индексы двух таких чисел, которые в сумме равны target.
 *
 * @param nums массив целочисленных значений
 * @param target целое число
 *
 * @return [x, y] - индексы двух чисел
 *
 * Гарантируется, что каждый ввод имеет ровно одно решение. Также учтите, что вы не можете использовать одно и то же число дважды.
 *
 * Вы можете вернуть ответ в любом порядке.
 *
 */

fun twoSum(nums: IntArray, target: Int): IntArray {
    for (i in 0..nums.size - 1)
        for (j in i + 1..nums.size - 1) {
            if (nums[i] + nums[j] == target) {
                val indexArray: IntArray = intArrayOf(i, j)
                return indexArray
            }
        }

    return intArrayOf()
}

fun twoSumOptimization(nums: IntArray, target: Int): IntArray {

    val hashMap: MutableMap<Int, Int> = mutableMapOf()

    nums.forEachIndexed { index, value ->
        if (value <= target)
            hashMap[index] = value
    }

    hashMap.forEach { key, value ->
        println("$key-$value")
    }

    for (i in hashMap.keys) {
        val targetSummand = target - hashMap[i]!!
        if (hashMap.containsValue(targetSummand)) {
            return intArrayOf(i)
        }
    }

    return intArrayOf()

}
fun twoSumHash(nums: IntArray, target: Int): IntArray? {
    val map: MutableMap<Int?, Int?> = HashMap()
    for (i in nums.indices) {
        map.put(nums[i], i)
    }
    for (i in nums.indices) {
        val complement = target - nums[i]
        if (map.containsKey(complement) && map[complement] != i) {
            return intArrayOf(i, map[complement]!!)
        }
    }

    return intArrayOf()
}

fun main() {
    val nums = intArrayOf(0, 2, 11, 8, 7, 15, 0)
    val result = twoSumHash(nums, 0)
    result?.forEach {
        print("$it ")
    }
}
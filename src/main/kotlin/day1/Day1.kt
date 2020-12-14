package main.kotlin.day1

import java.io.File

const val TARGET = 2020

fun main() {
    println(part1())
    println(part2())
}

fun part1(): Int {
    val inputNumberSet: MutableSet<Int> = mutableSetOf()
    File("src/main/resources/day1").forEachLine { inputNumberSet.add(it.toInt()) }
    inputNumberSet.forEach {
        val diffToTarget = TARGET - it
        if (inputNumberSet.contains(diffToTarget)) {
            return it * diffToTarget
        }
    }
    return -1
}

fun part2(): Int {
    val inputList = mutableListOf<Int>()
    File("src/main/resources/day1").forEachLine { inputList.add(it.toInt()) }
    inputList.sort()

    inputList.forEachIndexed { index, element ->
        var high = inputList.size - 1
        var low = index + 1

        while (high > low) {
            val currentSum = element +
              inputList[low] + inputList[high]
            if (currentSum > TARGET) high--
            else if (currentSum < TARGET) low++
            else return element * inputList[low] * inputList[high]
        }
    }
    return -1
}

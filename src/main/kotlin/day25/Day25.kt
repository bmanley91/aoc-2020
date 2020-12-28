package main.kotlin.day25

const val SUBJECT_NUMBER = 7L
const val DIVISOR = 20201227L

fun main() =
    println(part1(335121L, 363891L))

fun part1(cardPK: Long, doorPK: Long): Long {
    var door = 1L
    var card = 1L

    while(door != doorPK) {
        door = (door * SUBJECT_NUMBER) % DIVISOR
        card = (card * cardPK) % DIVISOR
    }
    
    return card
}

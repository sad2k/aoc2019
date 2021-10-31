package com.sad.aoc2019.day1

import com.sad.aoc2019.loadFromResources

private fun fuelRequired(mass: Int) = mass / 3 - 2

private fun fuelRequired2(mass: Int): Int {
    var fuel = fuelRequired(mass)
    var total = fuel

    while (fuel > 0) {
        fuel = fuelRequired(fuel)
        if (fuel > 0) {
            total += fuel
        }
    }

    return total
}

fun main() {
    val input: List<Int> = loadFromResources("day1.txt").readLines().map { it.toInt() }
    val res1 = input.map(::fuelRequired).sum()
    println("part 1: ${res1}")

    val res2 = input.map(::fuelRequired2).sum()
    println("part 1: ${res2}")
}
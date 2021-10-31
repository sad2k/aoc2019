package com.sad.aoc2019.day2

import com.sad.aoc2019.loadFromResources
import com.sad.aoc2019.readFirstLine
import java.io.File
import java.lang.IllegalArgumentException

private fun run(program: IntArray): Unit {
    var ptr = 0
    while (ptr < program.size) {
        val opcode = program[ptr]
        when (opcode) {
            1, 2 -> {
                val input1Pos = program[ptr + 1]
                val input2Pos = program[ptr + 2]
                val outputPos = program[ptr + 3]
                val input1 = program[input1Pos]
                val input2 = program[input2Pos]
                val output = if (opcode == 1) {
                    input1 + input2
                } else {
                    input1 * input2
                }
                program[outputPos] = output
                ptr += 4
            }
            99 -> break
            else -> throw IllegalArgumentException("Unsupported opcode: ${opcode}")
        }
    }
}

private fun parse(str: String): IntArray = str.split(",").map { it.toInt() }.toIntArray()

fun main() {
    // part 1
    val input = loadFromResources("day2.txt").readFirstLine()
    val program = parse(input)
    program[1] = 12
    program[2] = 2
    run(program)
    println(program[0])

    // part 2
    for (noun in 0..99) {
        for (verb in 0..99) {
            val program = parse(input)
            program[1] = noun
            program[2] = verb
            run(program)
            if (program[0] == 19690720) {
                println("Found: ${100 * noun + verb}")
            }
        }
    }
}



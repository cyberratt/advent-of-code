package net.cyberratt.advent.days.two

import net.cyberratt.advent.days.Day
import java.io.File

class Two : Day {
    override fun run() {
        val input = File("src/main/resources/day_two_input.txt")
            .readText()
            .split(',')
            .map { it.trim().toInt() }
            .toMutableList()

        val (result, noun, verb) = OpCodeProcessor(input).process()
        println("Result: $result, noun: $noun, verb: $verb")
    }
}
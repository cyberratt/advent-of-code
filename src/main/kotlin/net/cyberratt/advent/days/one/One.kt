package net.cyberratt.advent.days.one

import net.cyberratt.advent.days.Day
import java.io.File

class One : Day {
    override fun run() {
        val calculator = FuelCalculator()
        File("src/main/resources/day_one_input.txt")
            .readLines()
            .sumBy { calculator.calculateFuelForMass(it.toDouble()) }
            .run { println("Fuel total sum: $this") }
    }
}
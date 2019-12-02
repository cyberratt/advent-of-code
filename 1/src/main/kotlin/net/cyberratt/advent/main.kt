package net.cyberratt.advent

import java.io.File

class Main {
  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      val calculator = FuelCalculator()
      File("src/main/resources/input.txt")
        .readLines()
        .sumBy { calculator.calculateFuelForMass(it.toDouble()) }
        .run { println("Fuel total sum: $this") }
    }
  }
}

class FuelCalculator {
  fun calculateFuelForMass(mass: Double): Int {
    val fuel = (mass / 3.0).toInt() - 2
    return if (fuel > 0) {
      fuel + calculateFuelForMass(fuel.toDouble())
    } else {
      0
    }
  }
}

package net.cyberratt.advent.days.one

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
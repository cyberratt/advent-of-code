package net.cyberratt.advent.days.two

class OpCodeProcessor(private val program: MutableList<Int>) {

    fun process(): List<Int> {
        var result: Int
        for (verb in 0..99) {
            for (noun in 0..99) {
                result = program.toMutableList().let {
                    it[1] = noun
                    it[2] = verb
                    runProgram(it)
                }
                println("result: $result - noun: $noun - verb: $verb")
                if (result == Companion.SOLUTION) {
                    return listOf(result, noun, verb)
                }
            }
        }
        return listOf(-1, -1, -1)
    }

    private fun runProgram(program: MutableList<Int>): Int {
        for (chunks in program.chunked(4)) {
            val opCode = chunks[0]
            if (opCode == 1) {
                program[chunks[3]] = program[chunks[1]] + program[chunks[2]]
            } else if (opCode == 2) {
                program[chunks[3]] = program[chunks[1]] * program[chunks[2]]
            } else if (opCode == 99) {
                break
            } else {
                throw IllegalStateException("Unknown OpCode detected")
            }
        }

        return program[0]
    }

    companion object {
        private const val SOLUTION = 19690720
    }
}
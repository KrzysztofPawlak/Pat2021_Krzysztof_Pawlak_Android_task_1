package com.pawlak.krzysztof.calculator.calculators

class FibonacciCalculator : CalculableUnary {

    private var isCancelled : Boolean = false
    private val maxNNumberThatCanBeStoredInInt = 46

    override fun calculate(input: Int): Int {
        isCancelled = false
        val firstElement = 0
        val secondElement = 1
        return calc(input, firstElement, secondElement)
    }

    private tailrec fun calc(input: Int?, previous: Int, last: Int): Int {
        try {
            if (input == 0) return previous
            if (isCancelled) {
                throw Exception()
            }
        } catch (e: Exception) {
            return 0
        }
        return calc(input?.minus(1), last, previous + last)
    }

    override fun getMaxInput(): Int {
        return maxNNumberThatCanBeStoredInInt
    }

    fun cancel() {
        isCancelled = true
    }
}
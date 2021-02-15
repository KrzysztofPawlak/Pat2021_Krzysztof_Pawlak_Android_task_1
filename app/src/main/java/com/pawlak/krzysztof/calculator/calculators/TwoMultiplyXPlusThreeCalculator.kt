package com.pawlak.krzysztof.calculator.calculators

class TwoMultiplyXPlusThreeCalculator : CalculableUnary {

    override fun calculate(input: Int): Int {
        return 2 * input + 3
    }

    override fun getMaxInput(): Int {
        return (Int.MAX_VALUE / 2) - 3
    }
}
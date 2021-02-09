package com.pawlak.krzysztof.calculator.calculators

class TwoMultiplyXPlusThreeCalculator : OneArgumentCalculator {

    override fun calculate(arg: Int): Int {
        return 2 * arg + 3
    }

    override fun showInfo(): String {
        return "2 * x + 3 = y"
    }
}
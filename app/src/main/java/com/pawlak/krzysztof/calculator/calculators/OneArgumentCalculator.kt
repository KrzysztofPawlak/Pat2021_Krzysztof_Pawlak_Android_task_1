package com.pawlak.krzysztof.calculator.calculators

interface OneArgumentCalculator {

    fun calculate(arg: Int) : Int
    fun showInfo() : String
}
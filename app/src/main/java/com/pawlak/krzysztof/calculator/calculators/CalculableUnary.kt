package com.pawlak.krzysztof.calculator.calculators

interface CalculableUnary {
    fun calculate(input: Int) : Int
    fun getMaxInput() : Int
}
package com.pawlak.krzysztof.calculator.calculators

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

internal class CalculatorTest {

    private lateinit var calculator: FibonacciCalculator

    @Before
    fun setUp() {
        calculator = FibonacciCalculator()
    }

    @Test
    fun testFibonacci() {
        assertEquals(1, calculator.calculate(2))
        assertEquals(2, calculator.calculate(3))
        assertEquals(3, calculator.calculate(4))
        assertEquals(5, calculator.calculate(5))
        assertEquals(8, calculator.calculate(6))
        assertEquals(55, calculator.calculate(10))
        assertEquals(6765, calculator.calculate(20))
    }
}
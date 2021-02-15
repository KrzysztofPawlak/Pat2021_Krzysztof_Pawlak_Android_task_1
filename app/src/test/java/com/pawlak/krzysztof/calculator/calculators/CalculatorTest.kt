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
        assertEquals(1, calculator.fibonacci(2))
        assertEquals(2, calculator.fibonacci(3))
        assertEquals(3, calculator.fibonacci(4))
        assertEquals(5, calculator.fibonacci(5))
        assertEquals(8, calculator.fibonacci(6))
        assertEquals(55, calculator.fibonacci(10))
        assertEquals(6765, calculator.fibonacci(20))
    }
}
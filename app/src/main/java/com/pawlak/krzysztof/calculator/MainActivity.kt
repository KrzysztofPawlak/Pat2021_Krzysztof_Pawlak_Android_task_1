package com.pawlak.krzysztof.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.pawlak.krzysztof.calculator.calculators.CalculableUnary
import com.pawlak.krzysztof.calculator.calculators.FibonacciAsyncCalculator
import com.pawlak.krzysztof.calculator.calculators.TwoMultiplyXPlusThreeCalculator

class MainActivity : AppCompatActivity() {

    private lateinit var input: EditText
    private lateinit var output: TextView
    private lateinit var button: Button
    private lateinit var buttonFibonacci: Button
    private val BUNDLE_OUTPUT_KEY = "output"
    private lateinit var fibonacciCalculator: FibonacciAsyncCalculator

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        input = findViewById(R.id.input)
        output = findViewById(R.id.result)
        button = findViewById(R.id.button)
        buttonFibonacci = findViewById(R.id.button2)
        fibonacciCalculator = FibonacciAsyncCalculator(this)

        setOnClick(button, TwoMultiplyXPlusThreeCalculator())
        setOnClick(buttonFibonacci, fibonacciCalculator)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString(BUNDLE_OUTPUT_KEY, output.text.toString())
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        output.text = savedInstanceState.getString(BUNDLE_OUTPUT_KEY)
    }

    private fun setOnClick(button: Button, calculator: CalculableUnary) {
        button.setOnClickListener() {
            if (validate(input.text.toString(), calculator)) {
                output.text = calculator.calculate(
                        Integer.parseInt(input.text.toString())).toString()
            }
        }
    }

    private fun validate(inputAsString: String, calculator: CalculableUnary): Boolean {
        if (!isNumeric(inputAsString)) {
            input.error = getString(R.string.text_validation_error)
            return false
        }
        if (Integer.parseInt(inputAsString) > calculator.getMaxInput()) {
            input.error = getString(
                    R.string.text_validation_input_size_error) + calculator.getMaxInput()
            return false
        }
        return true
    }

    private fun isNumeric(inputAsString: String): Boolean {
        if (inputAsString.toIntOrNull() == null) {
            return false
        }
        return true
    }

    fun setResult(result: String?) {
        output.text = result
    }
}
package com.pawlak.krzysztof.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.pawlak.krzysztof.calculator.calculators.OneArgumentCalculator
import com.pawlak.krzysztof.calculator.calculators.TwoMultiplyXPlusThreeCalculator

class MainActivity : AppCompatActivity() {

    private lateinit var input: EditText
    private lateinit var output: TextView
    private lateinit var button: Button
    private val calculators = hashMapOf<String, OneArgumentCalculator>(
            "TwoMultiplyXPlusThreeCalculator" to TwoMultiplyXPlusThreeCalculator()
    )

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        input = findViewById(R.id.input)
        output = findViewById(R.id.result)
        button = findViewById(R.id.button)

        button.setOnClickListener() {
            output.text = calculators["TwoMultiplyXPlusThreeCalculator"]?.calculate(
                    Integer.parseInt(input.text.toString())).toString()
        }
    }
}
package net.yasik.sampleuitest

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        result = findViewById(R.id.result)

        val buttonOne = findViewById<Button>(R.id.button_one)
        val buttonTwo = findViewById<Button>(R.id.button_two)
        val buttonPlus = findViewById<Button>(R.id.button_plus)

        buttonOne.setOnClickListener { addNumber(1) }
        buttonTwo.setOnClickListener { addNumber(2) }
        buttonPlus.setOnClickListener { addOperation() }
    }

    private fun addNumber(number: Int) {
        val currentText = result.text.toString()
        result.text = currentText + number
    }

    private fun addOperation() {
        val currentText = result.text.toString()
        result.text = "$currentText+"
    }

    fun calculate(expression: String): Int {
        val parts = expression.split("\\+".toRegex()).toTypedArray()
        var sum = 0
        for (part in parts) {
            sum += part.toInt()
        }
        return sum
    }
}
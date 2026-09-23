package com.example.cyclicttest

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private var amplitude: Double = 0.0
    private var springId: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        springId = intent.getStringExtra("springId") ?: ""
        amplitude = intent.getDoubleExtra("amplitude", 0.0)

        val tvInfo = findViewById<TextView>(R.id.tvSpringInfo)
        tvInfo.text = "Пружина $springId\nАмплитуда " + formatNum(amplitude) + " мм"

        val etHeight = findViewById<EditText>(R.id.etHeight)
        val btnCalc = findViewById<Button>(R.id.btnCalculate)
        val btnClear = findViewById<Button>(R.id.btnClear)
        val btnBack = findViewById<Button>(R.id.btnSelectAnother)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnCalc.setOnClickListener {
            val raw = etHeight.text.toString().trim().replace(",", ".")
            if (raw.isEmpty()) {
                etHeight.error = "Введите высоту"
                return@setOnClickListener
            }
            val height = raw.toDoubleOrNull()
            if (height == null) {
                etHeight.error = "Некорректное значение"
                return@setOnClickListener
            }
            val minDist = height - amplitude - 40.0
            val maxDist = height + amplitude - 40.0
            tvResult.text = "Минимальное расстояние:\n" + formatNum(minDist) + " мм\n\n" +
                    "Максимальное расстояние:\n" + formatNum(maxDist) + " мм"
        }

        btnClear.setOnClickListener {
            etHeight.text.clear()
            tvResult.text = ""
            etHeight.error = null
        }

        btnBack.setOnClickListener {
            finish()
        }
    }

    private fun formatNum(v: Double): String {
        return if (v == v.toLong().toDouble())
            v.toLong().toString()
        else
            String.format("%.2f", v).replace(".", ",")
    }
}

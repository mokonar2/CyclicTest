package com.example.cyclicttest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnSpring003).setOnClickListener {
            openSecond("003", 21.0)
        }
        findViewById<Button>(R.id.btnSpring004).setOnClickListener {
            openSecond("004", 22.0)
        }
        findViewById<Button>(R.id.btnSpring005).setOnClickListener {
            openSecond("005", 22.0)
        }
    }

    private fun openSecond(springId: String, amplitude: Double) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("springId", springId)
        intent.putExtra("amplitude", amplitude)
        startActivity(intent)
    }
}

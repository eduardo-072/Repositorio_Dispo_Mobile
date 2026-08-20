package com.example.appoperacaomath

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val valor1 = findViewById<EditText>(R.id.valorGrau)
        val btn1 = findViewById<Button>(R.id.fahr)
        val btn2 = findViewById<Button>(R.id.cel)
        val resultado = findViewById<TextView>(R.id.txvResultado)
        val btnLimpar = findViewById<Button>(R.id.btnlimpar)

        btn1.setOnClickListener {
            val campo = valor1.text.toString().toDouble()
            val result = campo * 1.8 + 32
            resultado.text = "Convertendo de Celcius para Fahrenheit: $result"

        }

        btn2.setOnClickListener {
            val campo = valor1.text.toString().toDouble()
            val result = (campo - 31) / 1.8
            resultado.text = "Convertendo de Fahrenheit para Celcius: %.3f".format(result)

        }

        btnLimpar.setOnClickListener {

            valor1.text.clear()

            resultado.text = ""
        }

    }
}
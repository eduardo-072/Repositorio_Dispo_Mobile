package com.example.appconversor_temp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        var operacao = 0
        val numero1 = findViewById<EditText>(R.id.num1)
        val numero2 = findViewById<EditText>(R.id.num2)

        val soma = findViewById<Button>(R.id.btnSomar)
        val subtracao = findViewById<Button>(R.id.btnSub)
        val divisao = findViewById<Button>(R.id.btnDiv)
        val multiplicacao = findViewById<Button>(R.id.btnMult)

        val btnCalcular = findViewById<Button>(R.id.btnCalc)
        val resultado = findViewById<TextView>(R.id.txvResultado)
        val btnLimpar = findViewById<Button>(R.id.btnlimpar)

        soma.setOnClickListener{
            operacao = 1
        }
        subtracao.setOnClickListener{
            operacao = 2
        }
        divisao.setOnClickListener{
            operacao = 3
        }
        multiplicacao.setOnClickListener {
            operacao = 4
        }

            btnCalcular.setOnClickListener {

                if (numero1.text.isEmpty() || numero2.text.isEmpty()) {
                    resultado.text = "Digite os dois números!"
                    return@setOnClickListener
                }

                val valor1 = numero1.text.toString().toDouble()
                val valor2 = numero2.text.toString().toDouble()

                if (operacao == 0){
                    resultado.text = "Escolha uma operação"
                    return@setOnClickListener
                }
                when(operacao){
                    1 -> {
                        val result = valor1 + valor2
                        resultado.text = "Resultado da operacao: $result"
                    }

                    2 -> {
                        val result = valor1 - valor2
                        resultado.text = "Resultado da operacao: $result"
                    }

                    3 -> {
                        if(valor1 == 0.0){
                            resultado.text = "Divisão impossivel com 0"
                        } else if (valor2 == 0.0){
                            resultado.text = "Divisão impossivel com 0"
                        }
                        val result = valor1 / valor2
                        resultado.text = "resuldado da operacao: $result"
                    }

                    4 -> {
                        val result = valor1 * valor2
                        resultado.text = "resuldado da operacao: $result"
                    }

        }

    }
        btnLimpar.setOnClickListener {

            numero1.text.clear()
            numero2.text.clear()

            resultado.text = ""

            operacao = 0
        }
}}
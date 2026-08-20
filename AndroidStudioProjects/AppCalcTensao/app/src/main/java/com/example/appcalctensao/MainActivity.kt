package com.example.appcalctensao

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.appcalctensao.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtTensao = findViewById<EditText>(R.id.id1)
        val edtResistencia = findViewById<EditText>(R.id.id3)
        val edtCorrente = findViewById<EditText>(R.id.id2)

        val btnCalcular = findViewById<Button>(R.id.button)
        val txtResultado = findViewById<TextView>(R.id.txvResultado)

        btnCalcular.setOnClickListener {

            val tensao = edtTensao.text.toString().toDoubleOrNull()
            val resistencia = edtResistencia.text.toString().toDoubleOrNull()
            val corrente = edtCorrente.text.toString().toDoubleOrNull()

            // Tensão + Resistência = calcular Corrente
            if (tensao != null && resistencia != null && corrente == null) {

                if (resistencia == 0.0) {
                    txtResultado.text = "A resistência não pode ser 0."
                } else {
                    val resultado = tensao / resistencia
                    txtResultado.text = "Corrente = %.3f A".format(resultado)
                }

            }

            // Tensão + Corrente = calcular Resistência
            else if (tensao != null && corrente != null && resistencia == null) {

                if (corrente == 0.0) {
                    txtResultado.text = "A corrente não pode ser 0."
                } else {
                    val resultado = tensao / corrente
                    txtResultado.text = "Resistência = %.3f Ω".format(resultado)
                }

            }

            // Resistência + Corrente = calcular Tensão
            else if (resistencia != null && corrente != null && tensao == null) {

                val resultado = resistencia * corrente
                txtResultado.text = "Tensão = %.3f V".format(resultado)

            }

            // Caso tenha preenchido menos de 2 ou os 3 campos
            else {
                txtResultado.text = "Preencha exatamente 2 campos."
            }
        }
    }
}
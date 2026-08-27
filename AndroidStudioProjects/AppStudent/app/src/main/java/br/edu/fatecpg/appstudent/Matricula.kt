package br.edu.fatecpg.appstudent

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class TelaMatricula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matricula)

        val nomeAluno = intent.getStringExtra("NOME_ALUNO") ?: ""

        val txvNomeAluno = findViewById<TextView>(R.id.txvNomeAluno)
        val txvMatricula = findViewById<TextView>(R.id.txvMatricula)
        val btnGerarMatricula = findViewById<Button>(R.id.btnGerarMatricula)

        txvNomeAluno.text = "Aluno: $nomeAluno"

        btnGerarMatricula.setOnClickListener {
            val matricula = Random.nextInt(100000, 999999)
            txvMatricula.text = "Matrícula: $matricula"
        }
    }
}
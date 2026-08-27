package br.edu.fatecpg.appstudent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtNomeAluno = findViewById<EditText>(R.id.edtNomeAluno)
        val btnAvancar = findViewById<FloatingActionButton>(R.id.btnAvanca)
        val txvAviso = findViewById<TextView>(R.id.txvAviso)

        btnAvancar.setOnClickListener {
            val nome = edtNomeAluno.text.toString().trim()

            if (nome.isNotEmpty()) {
                val intent = Intent(this, TelaMatricula::class.java)
                intent.putExtra("NOME_ALUNO", nome)
                startActivity(intent)
            } else {
                txvAviso.text = "Digite o nome do aluno antes de avançar."
            }
        }
    }
}
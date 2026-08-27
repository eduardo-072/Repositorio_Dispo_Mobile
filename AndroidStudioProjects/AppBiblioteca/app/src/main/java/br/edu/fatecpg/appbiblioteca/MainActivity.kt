package br.edu.fatecpg.appbiblioteca

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

        val edtValor1 = findViewById<EditText>(R.id.valor1)
        val edtValor2 = findViewById<EditText>(R.id.valor2)
        val txvResultado = findViewById<TextView>(R.id.txvResultado)
        val btnCadastrar = findViewById<Button>(R.id.btnCadastrar)
        val btnAvancar = findViewById<FloatingActionButton>(R.id.btnAvanca)

        btnCadastrar.setOnClickListener {
            val livro = edtValor1.text.toString()
            val autorOuDetalhe = edtValor2.text.toString()

            if (livro.isNotEmpty() && autorOuDetalhe.isNotEmpty()) {
                Biblioteca.livros.add(Livro(livro, autorOuDetalhe))
                txvResultado.text = getString(R.string.livro_cadastrado, livro)
                edtValor1.text.clear()
                edtValor2.text.clear()
            } else {
                txvResultado.text = getString(R.string.preencha_campos)
            }
        }

        btnAvancar.setOnClickListener {
            val tela = Intent(this, TelaDashboardLivros::class.java)
            startActivity(tela)
        }
    }
}
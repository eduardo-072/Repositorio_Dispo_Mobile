package br.edu.fatecpg.appbiblioteca

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

data class Livro(
    val titulo: String,
    val autor: String
)

object Biblioteca {
    val livros = mutableListOf<Livro>()
}

class TelaDashboardLivros : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela_dashboard_livros)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnVoltar = findViewById<FloatingActionButton>(R.id.btnBack)
        val listaLivros = findViewById<ListView>(R.id.listaLivros)

        val itens = Biblioteca.livros.map { "${it.titulo} - ${it.autor}" }
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, itens)
        listaLivros.adapter = adapter

        btnVoltar.setOnClickListener {
            finish()
        }
    }
}
package br.universidade.projeto

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import br.universidade.projeto.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthRecentLoginRequiredException

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = auth.currentUser
        if (user == null) { voltarParaLogin(); return }

        binding.txtEmail.text = user.email
        binding.btnSair.setOnClickListener {
            auth.signOut()
            voltarParaLogin()
        }
        binding.btnExcluir.setOnClickListener { confirmarExclusao() }
    }

    private fun confirmarExclusao() {
        AlertDialog.Builder(this)
            .setTitle("Excluir conta")
            .setMessage("Tem certeza? Sua conta será excluída permanentemente.")
            .setNegativeButton("Cancelar", null)
            .setPositiveButton("Excluir") { _, _ -> excluirConta() }
            .show()
    }

    private fun excluirConta() {
        val user = auth.currentUser ?: return voltarParaLogin()
        binding.btnExcluir.isEnabled = false
        user.delete().addOnCompleteListener { task ->
            binding.btnExcluir.isEnabled = true
            if (task.isSuccessful) {
                Toast.makeText(this, "Conta excluída com sucesso", Toast.LENGTH_LONG).show()
                voltarParaLogin()
            } else {
                val msg = if (task.exception is FirebaseAuthRecentLoginRequiredException)
                    "Por segurança, saia e entre novamente antes de excluir a conta"
                else task.exception?.localizedMessage ?: "Erro desconhecido"
                Toast.makeText(this, "Falha ao excluir: $msg", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun voltarParaLogin() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}

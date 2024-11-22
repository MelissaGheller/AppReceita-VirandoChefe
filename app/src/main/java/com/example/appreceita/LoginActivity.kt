package com.example.appreceita

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginActivity : AppCompatActivity() {

    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        db = AppDatabase.getInstance(this)

        val btnLogin = findViewById<Button>(R.id.btn_login)
        val etEmail = findViewById<EditText>(R.id.et_email)
        val etSenha = findViewById<EditText>(R.id.et_senha)

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString()
            val senha = etSenha.text.toString()

            GlobalScope.launch(Dispatchers.IO) {
                val usuario = db.usuarioDao().autenticar(email, senha)
                withContext(Dispatchers.Main) {

                    if (usuario != null) {
                        Toast.makeText(this@LoginActivity, "Bem-vindo, ${usuario.nome}!", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                    } else {
                        Toast.makeText(this@LoginActivity, "E-mail ou senha incorretos", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        findViewById<TextView>(R.id.tv_cadastro).setOnClickListener {
            startActivity(Intent(this, CadastroUsuarioActivity::class.java))
        }
    }
}

package com.example.appreceita

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CadastroUsuarioActivity : AppCompatActivity() {

    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_usuario)

        db = AppDatabase.getInstance(this)

        val etNome = findViewById<EditText>(R.id.et_nome)
        val etEmail = findViewById<EditText>(R.id.et_email)
        val etSenha = findViewById<EditText>(R.id.et_senha)
        val etDataNascimento = findViewById<EditText>(R.id.et_data_nascimento)
        val btnSalvar = findViewById<Button>(R.id.btn_salvar_usuario)

        btnSalvar.setOnClickListener {
            val nome = etNome.text.toString()
            val email = etEmail.text.toString()
            val senha = etSenha.text.toString()
            val dataNascimento = etDataNascimento.text.toString()

            val usuario = Usuario(nome = nome, email = email, senha = senha, dataNascimento = dataNascimento)

            GlobalScope.launch(Dispatchers.IO) {
                db.usuarioDao().inserir(usuario)
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@CadastroUsuarioActivity, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }
    }
}

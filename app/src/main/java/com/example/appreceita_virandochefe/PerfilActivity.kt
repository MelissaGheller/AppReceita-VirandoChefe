package com.example.virandochefe

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PerfilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        val btnSalvar = findViewById<Button>(R.id.btn_salvar)
        btnSalvar.setOnClickListener {
            val nome = findViewById<EditText>(R.id.et_nome).text.toString()
            val email = findViewById<EditText>(R.id.et_email).text.toString()
            val senha = findViewById<EditText>(R.id.et_senha).text.toString()

            Toast.makeText(this, "Perfil atualizado com sucesso!", Toast.LENGTH_SHORT).show()
        }
    }


}

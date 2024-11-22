package com.example.appreceita

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_bebidas).setOnClickListener {
            startActivity(Intent(this, CategoriasActivity::class.java).apply {
                putExtra("categoria", "Bebidas")
            })
        }

        findViewById<Button>(R.id.btn_doces).setOnClickListener {
            startActivity(Intent(this, CategoriasActivity::class.java).apply {
                putExtra("categoria", "Doces")
            })
        }

        findViewById<Button>(R.id.btn_salgados).setOnClickListener {
            startActivity(Intent(this, CategoriasActivity::class.java).apply {
                putExtra("categoria", "Salgados")
            })
        }

        findViewById<ImageView>(R.id.iconBack).setOnClickListener {

        }

        findViewById<ImageView>(R.id.iconSearch).setOnClickListener {
        }

        findViewById<ImageView>(R.id.iconAdd).setOnClickListener {
            verificarLoginEAdicionarReceita()
        }

        findViewById<ImageView>(R.id.iconProfile).setOnClickListener {
            startActivity(Intent(this, PerfilActivity::class.java))
        }
    }

    private fun verificarLoginEAdicionarReceita() {
        val usuarioLogado = true
        if (usuarioLogado) {
            startActivity(Intent(this, CadastroReceitaActivity::class.java))
        } else {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}

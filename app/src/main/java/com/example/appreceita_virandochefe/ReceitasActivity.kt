package com.example.virandochefe

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class ReceitasActivity : AppCompatActivity() {

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receitas)

        val categoria = intent.getStringExtra("nome_categoria") ?: "Receitas"
        val scrollReceitas = findViewById<LinearLayout>(R.id.scrollReceitas)

        val receitas = listOf(
            "Bolo de Cenoura", "Bolo de Chocolate", "Torta de Limão"
        )

        receitas.forEach { nomeReceita ->
            val botao = Button(this).apply {
                text = nomeReceita
                setOnClickListener {
                    val intent = Intent(this@ReceitasActivity, DetalhesReceitaActivity::class.java)
                    intent.putExtra("nome_receita", nomeReceita)
                    startActivity(intent)
                }
            }
            scrollReceitas.addView(botao)
        }
    }
}

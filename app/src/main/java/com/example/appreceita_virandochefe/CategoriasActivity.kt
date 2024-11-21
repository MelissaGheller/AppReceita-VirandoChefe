package com.example.virandochefe

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class CategoriasActivity : AppCompatActivity() {

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categorias)


        val categoriaSelecionada = intent.getStringExtra("categoria") ?: "Categorias"
        val scrollCategorias = findViewById<LinearLayout>(R.id.scrollCategorias)


        val categorias = when (categoriaSelecionada) {
            "Bebidas" -> listOf("Sucos Naturais", "Drinks Alcoólicos", "Coquetéis sem Álcool")
            "Doces" -> listOf("Bolos", "Tortas Doces", "Sobremesas Variadas")
            "Salgados" -> listOf("Massas", "Sopas", "Lanches Saudáveis")
            else -> emptyList()
        }

        categorias.forEach { nomeCategoria ->
            val botao = Button(this).apply {
                text = nomeCategoria
                setOnClickListener {

                    val intent = Intent(this@CategoriasActivity, ReceitasActivity::class.java)
                    intent.putExtra("nome_categoria", nomeCategoria)
                    startActivity(intent)
                }
            }
            scrollCategorias.addView(botao)
        }
    }
}

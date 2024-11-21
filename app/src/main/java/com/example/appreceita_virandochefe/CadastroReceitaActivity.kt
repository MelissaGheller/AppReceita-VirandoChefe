package com.example.virandochefe

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appreceita_virandochefe.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CadastroReceitaActivity : AppCompatActivity() {

    private lateinit var db: AppDatabase
    private var usuarioId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_receita)

        db = AppDatabase.getInstance(this)

        val etNomeReceita = findViewById<EditText>(R.id.et_nome_receita)
        val etIngredientes = findViewById<EditText>(R.id.et_ingredientes)
        val etModoPreparo = findViewById<EditText>(R.id.et_modo_preparo)
        val btnSalvarReceita = findViewById<Button>(R.id.btn_salvar_receita)

        btnSalvarReceita.setOnClickListener {
            val nomeReceita = etNomeReceita.text.toString()
            val ingredientes = etIngredientes.text.toString()
            val modoPreparo = etModoPreparo.text.toString()

            val receita = Receita(
                nome = nomeReceita,
                categoria = "Doces",
                tempoPreparo = "30 min",
                qtdeServe = 4,
                ingredientes = ingredientes,
                modoPreparo = modoPreparo,
                usuarioId = usuarioId
            )

            GlobalScope.launch(Dispatchers.IO) {
                db.receitaDao().inserir(receita)
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@CadastroReceitaActivity, "Receita cadastrada com sucesso!", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }
    }
}

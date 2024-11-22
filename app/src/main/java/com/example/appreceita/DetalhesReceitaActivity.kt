package com.example.appreceita

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetalhesReceitaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_receita)

        val nomeReceita = intent.getStringExtra("nome_receita") ?: "Receita Desconhecida"

        val infoReceita = "Tempo de preparo: 45 minutos\nServe: 6 pessoas"
        val ingredientes = "2 xícaras de farinha de trigo\n1 xícara de açúcar\n2 ovos\n1 xícara de leite"
        val modoPreparo = "1. Misture os ingredientes secos.\n2. Adicione os líquidos e mexa bem.\n3. Asse a 180°C por 30 minutos."

        findViewById<TextView>(R.id.tv_nome_receita).text = nomeReceita
        findViewById<TextView>(R.id.tv_info_receita).text = infoReceita
        findViewById<TextView>(R.id.tv_ingredientes).text = ingredientes
        findViewById<TextView>(R.id.tv_modo_preparo).text = modoPreparo
    }
}

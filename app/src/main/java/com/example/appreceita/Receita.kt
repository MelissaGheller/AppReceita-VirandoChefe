package com.example.appreceita

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "receitas")
data class Receita(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nome: String,
    val categoria: String,
    val tempoPreparo: String,
    val qtdeServe: Int,
    val ingredientes: String,
    val modoPreparo: String,
    val usuarioId: Int
)

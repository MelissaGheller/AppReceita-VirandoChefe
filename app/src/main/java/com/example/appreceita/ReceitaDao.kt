package com.example.appreceita

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ReceitaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun inserir(receita: Receita)

    @Query("SELECT * FROM receitas WHERE categoria = :categoria")
    fun buscarPorCategoria(categoria: String): List<Receita>

    @Query("SELECT * FROM receitas WHERE id = :id")
    fun buscarPorId(id: Int): Receita
}

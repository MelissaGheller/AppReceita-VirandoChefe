package com.example.virandochefe

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ReceitaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserir(receita: Receita)

    @Query("SELECT * FROM receitas WHERE categoria = :categoria")
    suspend fun buscarPorCategoria(categoria: String): List<Receita>

    @Query("SELECT * FROM receitas WHERE id = :id")
    suspend fun buscarPorId(id: Int): Receita
}

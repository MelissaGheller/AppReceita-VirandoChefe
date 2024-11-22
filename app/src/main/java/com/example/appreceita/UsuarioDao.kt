package com.example.appreceita

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UsuarioDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun inserir(usuario: Usuario)

    @Query("SELECT * FROM usuarios WHERE email = :email AND senha = :senha")
    fun autenticar(email: String, senha: String): Usuario?

    @Query("SELECT * FROM usuarios WHERE id = :id")
    fun buscarPorId(id: Int): Usuario?
}



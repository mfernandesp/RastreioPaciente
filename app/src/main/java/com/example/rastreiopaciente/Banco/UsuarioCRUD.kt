package com.example.rastreiopaciente.Banco

import android.arch.persistence.room.*


@Dao
interface UsuarioCRUD {

    @Insert  // or OnConflictStrategy.IGNORE
    fun inserirUsuario(usuario: Usuario)

    @Delete
    fun deleteUsuario(usuario: Usuario)

    @Update
    fun updateUsuario(usuario: Usuario)

    @Query("select * from Usuario")
    fun listarUsuarios(): List<Usuario>

    @Query("select * from Usuario where id_usuario=:id")
    fun getUsuario(id:Int): Usuario

}
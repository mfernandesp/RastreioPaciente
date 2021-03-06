package com.example.rastreiopaciente.Banco

import android.arch.persistence.room.*


@Dao
interface AtendimentoCRUD {

    @Insert  // or OnConflictStrategy.IGNORE
    fun inserirAtendimento(atendimento: Atendimento)

    @Delete
    fun deleteAtendimento(atendimento: Atendimento)

    @Update
    fun updateAtendimento(atendimento: Atendimento)

    @Query("select * from Atendimento")
    fun listarAtendimentos(): List<Atendimento>

    @Query("select * from Atendimento where id_atendimento=:id")
    fun getAtendimento(id:Int): Atendimento

}
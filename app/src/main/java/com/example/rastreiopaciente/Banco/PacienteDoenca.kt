package com.example.rastreiopaciente.Banco

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class PacienteDoenca {


    @PrimaryKey
    var id_pacienteDoenca:Int?=0
    @ColumnInfo(name = "id_paciente")
    var id_paciente:Int?=0
    @ColumnInfo(name = "id_doenca")
    var id_doenca:Int?=0

}

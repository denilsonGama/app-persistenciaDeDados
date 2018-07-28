package br.com.fiap.persistnciadedados._13_6.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "aluno")
class Aluno {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    @ColumnInfo(name = "nomecompleto")
    var nomecompleto: String? = null

    @ColumnInfo(name = "idade")
    var idade: Int? = null

    @ColumnInfo(name = "rm")
    var rm: Int? = null

}
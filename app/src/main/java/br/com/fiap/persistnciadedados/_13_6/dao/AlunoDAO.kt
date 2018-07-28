package br.com.fiap.persistnciadedados._13_6.dao

import android.arch.persistence.room.*
import br.com.fiap.persistnciadedados._13_6.entity.Aluno

@Dao
interface AlunoDAO {

    @Insert
    fun ins(vararg aluno: Aluno)

    @Update
    fun upd(vararg aluno: Aluno)

    @Delete
    fun del(vararg aluno: Aluno)

    @Query("select * from aluno where id = :id")
    fun get(id: Int): Aluno

    @Query("select * from aluno order by id desc")
    fun all(): Array<Aluno>
}

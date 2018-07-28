package br.com.fiap.persistnciadedados._13_6.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import br.com.fiap.persistnciadedados._13_6.dao.AlunoDAO
import br.com.fiap.persistnciadedados._13_6.entity.Aluno

@Database(entities = arrayOf(Aluno::class), version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {

    abstract fun alunoDAO(): AlunoDAO

    companion object {

        private var instance: AppDataBase? = null

        private val DATABASE: String = "fiapdb"

        fun getAppDatabase(context: Context): AppDataBase {

            if (instance == null) {

                instance = Room.databaseBuilder(context.applicationContext,
                        AppDataBase::class.java,
                        DATABASE)
                        .allowMainThreadQueries()
                        .build()
            }

            return instance as AppDataBase
        }
    }
}

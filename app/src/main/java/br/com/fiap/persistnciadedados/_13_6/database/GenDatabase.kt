package br.com.fiap.persistnciadedados._13_6.database

import br.com.fiap.persistnciadedados._13_6.entity.Aluno

class GenDatabase {

    //-------------------------------------------------------------------
    //-------------------------------------------------------------------
    //-------------------------------------------------------------------
    fun isPopulateAluno() : Boolean {

        if (database == null)
            return false

        var count: Int? = database!!.alunoDAO().all().size

        return (count!! > 0)
    }
    //-------------------------------------------------------------------
    //-------------------------------------------------------------------
    //-------------------------------------------------------------------
    fun getAlunos() : String {

        if (database == null)
            return String()

        var alunos: Array<Aluno> = database!!.alunoDAO().all()

        var retorno: String = String()

        for(aluno in alunos) {
            retorno += "RM:" + aluno.rm + "|" + aluno.id + " " + aluno.idade + "y " + aluno.nomecompleto + "\n"
        }

        return retorno
    }
    //-------------------------------------------------------------------
    //-------------------------------------------------------------------
    //-------------------------------------------------------------------
    fun generateAluno() {

        if (database == null)
            return

        val alunos = arrayOfNulls<Aluno>(4)
        alunos[0] = alunoInstance("Anthony Edward Stark", 20, 1234567)
        alunos[1] = alunoInstance("Janet van Dyne"      , 21, 1234568)
        alunos[2] = alunoInstance("Wanda Maximoff"      , 22, 1234569)
        alunos[3] = alunoInstance("Henry Jonathan Pyme" , 23, 1234560)

        for(aluno in alunos) {
            database!!.alunoDAO().ins(aluno!!)
        }
    }
    //-------------------------------------------------------------------
    //-------------------------------------------------------------------
    //-------------------------------------------------------------------
    private fun alunoInstance(nomecompleto: String, idade: Int, rm: Int): Aluno {

        val aluno = Aluno()

        aluno.nomecompleto = nomecompleto
        aluno.idade = idade
        aluno.rm = rm

        return aluno
    }
    //-------------------------------------------------------------------
    //-------------------------------------------------------------------
    //-------------------------------------------------------------------
    companion object {

        private var instance: GenDatabase? = null
        private var database: AppDataBase? = null

        fun with(appDataBase: AppDataBase): GenDatabase {

            if (database == null)
                database = appDataBase

            if (instance == null)
                instance = GenDatabase()

            return instance as GenDatabase
        }
    }
    //-------------------------------------------------------------------
}
package br.com.fiap.persistnciadedados._13_6

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import br.com.fiap.persistnciadedados.R
import br.com.fiap.persistnciadedados._13_6.database.AppDataBase
import br.com.fiap.persistnciadedados._13_6.database.GenDatabase
import br.com.fiap.persistnciadedados._13_6.entity.Aluno

/*
* Neste módulo iremos conhecer como programarmos com JSON.
* JSON é conhecido como transferência/intercâmbio de dados, um formato simples, leve e
* que todas as trocas de dados sejam feitas com o mesmo formato.
*/
class Persistencia_de_dados_com_Room : AppCompatActivity() {

    //-- Declarando os componentes gráficos que estão no layout
    var name: EditText? = null
    var age: EditText? = null
    var rm: EditText? = null
    var box : TextView? = null

    var database: AppDataBase? = null

    //-- Este é o principal método. Sempre irá processar inicialmente
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        //-- Vinculando o layout xml com a rotina de programação
        setContentView(R.layout.persistencia_de_dados_com_room)

        database = AppDataBase.getAppDatabase(applicationContext)

        //-- Capturando os dados na tela
        name = findViewById(R.id.name) as EditText
        age = findViewById(R.id.age) as EditText
        rm = findViewById(R.id.rm) as EditText
        box = findViewById(R.id.box) as TextView

        //-- Dados de exemplo
        name!!.setText("Lins de Vasconcelos")
        age!!.setText("63")
        rm!!.setText("1324576")

        if(!GenDatabase.with(database!!).isPopulateAluno()) {
            GenDatabase.with(database!!).generateAluno()
        }

        //-- Formatação ilustrativa do JSON com os dados exemplo
        var dados: String = GenDatabase.with(database!!).getAlunos()
        box!!.setText(dados)
    }

    fun gravarDadosRoom(view: View) {

        //-- Recuperando os dados digitados
        var myName = name!!.text
        var myAge  = age!!.text
        var myRM = rm!!.text


        //-- Verificando se todas as informações foram preenchidas
        if(myName.isNotEmpty() && myAge.isNotEmpty() && myRM.isNotEmpty()) {

            val aluno = Aluno()

            aluno.nomecompleto = myName.toString()
            aluno.idade = myAge.toString().toInt()
            aluno.rm = myRM.toString().toInt()

            database!!.alunoDAO().ins(aluno)

            //-- Formatação ilustrativa do JSON com os dados exemplo
            var dados: String = GenDatabase.with(database!!).getAlunos()
            box!!.setText(dados)

            name!!.text.clear()
            age!!.text.clear()
            rm!!.text.clear()

            name!!.requestFocus()

        } else {
            Toast.makeText(applicationContext,"Todos os dados são obrigatórios!", Toast.LENGTH_LONG).show();
        }
    }
}
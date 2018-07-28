package br.com.fiap.persistnciadedados._13_2

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.Toast
import br.com.fiap.persistnciadedados.R

/*
* Neste módulo iremos conhecer uma outra forma de persistir dados internamente
* no aplicativo, esta forma é chamada de Shared Preferences ou preferencias compartilhadas
 */
class Persistindo_dados_com_SharedPreferences : AppCompatActivity() {

    //-- Declarando os componentes gráficos que estão no layout
    var name: EditText? = null
    var age: EditText? = null
    var rm: EditText? = null

    //-- Declarando os objetos de gerenciamento de Shared Preferences
    var sharedPref:SharedPreferences?=null
    var editor:SharedPreferences.Editor?=null

    //-- Este é o principal método. Sempre irá processar inicialmente
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        //-- Vinculando o layout xml com a rotina de programação
        setContentView(R.layout.persistindo_dados_com_sharedpreferences)

        //-- Capturando os dados na tela
        name = findViewById(R.id.name) as EditText
        age = findViewById(R.id.age) as EditText
        rm = findViewById(R.id.rm) as EditText

        //-- Ativando o arquivo FIAP para verificar se existem informações
        sharedPref = getSharedPreferences("fiap", Context.MODE_PRIVATE)
        editor=sharedPref!!.edit()

        //-- Verificando se o campo NAME existe na Sharef Preferences
        if(sharedPref!!.contains("name")) {

            //-- Dados capturados
            name!!.setText(sharedPref!!.getString("name", ""))
            age!!.setText(sharedPref!!.getInt("age", 0).toString())
            rm!!.setText(sharedPref!!.getInt("rm", 0).toString())

        } else {

            //-- Dados de exemplo
            name!!.setText("Lins de Vasconcelos")
            age!!.setText("63")
            rm!!.setText("1324576")
        }
    }

    //-- Função que será ativada quando clicar o botão
    fun gerarSharefPreferences(view: View) {

        //-- Recuperando os dados digitados
        var myName = name!!.text
        var myAge  = age!!.text
        var myRM = rm!!.text

        //-- Verificando se todas as informações foram preenchidas
        if(myName.isNotEmpty() && myAge.isNotEmpty() && myRM.isNotEmpty()) {

            //-- Ativando o arquivo FIAP para gravação de informações internamente
            sharedPref = getSharedPreferences("fiap", Context.MODE_PRIVATE)

            editor = sharedPref!!.edit()
            editor!!.putString("name", myName.toString())
            editor!!.putInt("age", myAge.toString().toInt())
            editor!!.putInt("rm", myRM.toString().toInt())
            editor!!.apply()

            //-- Mensagem para o usuário
            Toast.makeText(applicationContext,"Shared Preferences Armazenado!\n\nRetorne ao Menu Principal", Toast.LENGTH_LONG).show();

            //-- Limpando os campos do formulário
            name!!.setText("")
            age!!.setText("")
            rm!!.setText("")

            //-- Colocando foco no campo name
            name!!.requestFocus()

        } else {
            Toast.makeText(applicationContext,"Todos os dados são obrigatórios!", Toast.LENGTH_LONG).show();
        }
    }
}
package br.com.fiap.persistnciadedados._13_3

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import br.com.fiap.persistnciadedados.R
import org.json.JSONObject

/*
* Neste módulo iremos conhecer como programarmos com JSON.
* JSON é conhecido como transferência/intercâmbio de dados, um formato simples, leve e
* que todas as trocas de dados sejam feitas com o mesmo formato.
*/
class Como_trabalhar_com_JSON : AppCompatActivity() {

    //-- Declarando os componentes gráficos que estão no layout
    var name: EditText? = null
    var age: EditText? = null
    var rm: EditText? = null
    var box : TextView? = null

    //-- Este é o principal método. Sempre irá processar inicialmente
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        //-- Vinculando o layout xml com a rotina de programação
        setContentView(R.layout.como_trabalhar_com_json)

        //-- Capturando os dados na tela
        name = findViewById(R.id.name) as EditText
        age = findViewById(R.id.age) as EditText
        rm = findViewById(R.id.rm) as EditText
        box = findViewById(R.id.box) as TextView

        //-- Dados de exemplo
        name!!.setText("Lins de Vasconcelos")
        age!!.setText("63")
        rm!!.setText("1324576")

        //-- Formatação ilustrativa do JSON com os dados exemplo
        var exemploJSON: String = "\n\nExemplo de dados no formato JSON:\n\n{\n\n\"name\":\"Lins de Vasconcelos\",\n\n\"age\":63,\n\n\"rm\":1324576\n\n}"
        box!!.setText(exemploJSON)
    }

    fun gerarJSON(view: View) {

        //-- Recuperando os dados digitados
        var myName = name!!.text
        var myAge  = age!!.text
        var myRM = rm!!.text


        //-- Verificando se todas as informações foram preenchidas
        if(myName.isNotEmpty() && myAge.isNotEmpty() && myRM.isNotEmpty()) {

            //-- Gerando um objeto JSON
            var json: JSONObject = JSONObject()

            //-- Inserindo informações no objeto JSON
            json.put("name",myName.toString())
            json.put("age",myAge.toString().toInt())
            json.put("rm",myRM.toString().toInt())

            //-- Apresentando os dados na tela
            Log.e("Saida",json.toString())
            box!!.setText(json.toString())

        } else {
            Toast.makeText(applicationContext,"Todos os dados são obrigatórios!", Toast.LENGTH_LONG).show();
        }
    }
}
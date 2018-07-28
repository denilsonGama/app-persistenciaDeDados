package br.com.fiap.persistnciadedados._13_1

import android.content.Intent
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
class Configuracoes_do_arquivo_Bundle : AppCompatActivity() {

    //-- Declarando os componentes gráficos que estão no layout
    var name: EditText? = null
    var age: EditText? = null
    var rm: EditText? = null

    //-- Este é o principal método. Sempre irá processar inicialmente
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        //-- Vinculando o layout xml com a rotina de programação
        setContentView(R.layout.configuracoes_do_arquivo_bundle)

        //-- Capturando os dados na tela
        name = findViewById(R.id.name) as EditText
        age = findViewById(R.id.age) as EditText
        rm = findViewById(R.id.rm) as EditText

        //-- Dados de exemplo
        name!!.setText("Lins de Vasconcelos")
        age!!.setText("63")
        rm!!.setText("1324576")
   }

    //-- Função que será ativada quando clicar o botão
    fun usarBundle(view: View) {

        //-- Recuperando os dados digitados
        var myName = name!!.text
        var myAge  = age!!.text
        var myRM = rm!!.text

        //-- Verificando se todas as informações foram preenchidas
        if(myName.isNotEmpty() && myAge.isNotEmpty() && myRM.isNotEmpty()) {

            val intent = Intent(this, Configuracoes_do_arquivo_Bundle_Tela1::class.java)
            intent.putExtra("name", myName)
            intent.putExtra("age", myAge)
            intent.putExtra("rm", myRM)
            startActivity(intent)

            //-- Mensagem para o usuário
            Toast.makeText(applicationContext,"Intent armazenado!\n\nDados enviados para tela 1", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(applicationContext,"Todos os dados são obrigatórios!", Toast.LENGTH_LONG).show();
        }
    }
}
package br.com.fiap.persistnciadedados._13_1

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import br.com.fiap.persistnciadedados.MainActivity
import br.com.fiap.persistnciadedados.R

/*
* Neste módulo iremos conhecer uma outra forma de persistir dados internamente
* no aplicativo, esta forma é chamada de Shared Preferences ou preferencias compartilhadas
 */
class Configuracoes_do_arquivo_Bundle_Tela2 : AppCompatActivity() {

    //-- Declarando os componentes gráficos que estão no layout
    var name: TextView? = null
    var age: TextView? = null
    var rm: TextView? = null

    //-- Recuperando os dados digitados
    var myName: String? = null
    var myAge: String? = null
    var myRM: String? = null

    //-- Este é o principal método. Sempre irá processar inicialmente
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        //-- Vinculando o layout xml com a rotina de programação
        setContentView(R.layout.configuracoes_do_arquivo_bundle_tela2)

        //-- Capturando os dados na tela
        name = findViewById(R.id.name) as TextView
        age = findViewById(R.id.age) as TextView
        rm = findViewById(R.id.rm) as TextView

        val bundle = intent.extras
        myName = bundle.get("name").toString()
        myAge = bundle.get("age").toString()
        myRM = bundle.get("rm").toString()

        //-- Dados capturados
        name!!.setText(myName)
        age!!.setText(myAge)
        rm!!.setText(myRM)

    }

    //-- Função que será ativada quando clicar o botão
    fun usarBundle(view: View) {

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

        //-- Mensagem para o usuário
        Toast.makeText(applicationContext,"Retornando ao Menu Principal", Toast.LENGTH_LONG).show();
    }
}
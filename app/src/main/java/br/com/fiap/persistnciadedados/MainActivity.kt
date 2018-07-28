package br.com.fiap.persistnciadedados

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import br.com.fiap.persistnciadedados._13_1.Configuracoes_do_arquivo_Bundle
import br.com.fiap.persistnciadedados._13_2.Persistindo_dados_com_SharedPreferences
import br.com.fiap.persistnciadedados._13_3.Como_trabalhar_com_JSON
import br.com.fiap.persistnciadedados._13_4.Views_personalizadas_com_RecyclerView
import br.com.fiap.persistnciadedados._13_5.Personalizando_celulas_em_uma_View
import br.com.fiap.persistnciadedados._13_6.Persistencia_de_dados_com_Room

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        13.1 Configurações do arquivo Bundle
        13.2 Persistindo dados com SharedPreferences
        13.3 Como trabalhar com JSON
        13.4 Views personalizadas com RecyclerView
        13.5 Personalizando células em uma View
        13.6 Persistência de dados com Room
         */
    }

    fun configuracoes_do_arquivo_bundle(view: View) {
        val intent = Intent(this, Configuracoes_do_arquivo_Bundle::class.java)
        startActivity(intent)
    }

    fun persistindo_dados_com_sharedpreferences(view: View) {
        val intent = Intent(this, Persistindo_dados_com_SharedPreferences::class.java)
        startActivity(intent)
    }

    fun como_trabalhar_com_json(view: View) {
        val intent = Intent(this, Como_trabalhar_com_JSON::class.java)
        startActivity(intent)
    }

    fun views_personalizadas_com_recyclerview(view: View) {
        val intent = Intent(this, Views_personalizadas_com_RecyclerView::class.java)
        startActivity(intent)
    }

    fun personalizando_celulas_em_uma_view(view: View) {
        val intent = Intent(this, Personalizando_celulas_em_uma_View::class.java)
        startActivity(intent)
    }

    fun persistencia_de_dados_com_room(view: View) {
        val intent = Intent(this, Persistencia_de_dados_com_Room::class.java)
        startActivity(intent)
    }





}

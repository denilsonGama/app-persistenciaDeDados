package br.com.fiap.persistnciadedados._13_5

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import br.com.fiap.persistnciadedados.R
import br.com.fiap.persistnciadedados.data.DataWarehouse
import org.json.JSONArray
import org.json.JSONObject
import java.util.*


class Personalizando_celulas_em_uma_View : AppCompatActivity() {


    var isFabOpen: Boolean = false

    lateinit var fab:  FloatingActionButton
    lateinit var fab1: FloatingActionButton
    lateinit var fab2: FloatingActionButton

    var fab_open: Animation? = null
    var fab_close: Animation? = null
    var rotate_forward: Animation? = null
    var rotate_backward: Animation? = null

    var listView: ListView? = null

    //-- Este é o principal método. Sempre irá processar inicialmente
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        //-- Vinculando o layout xml com a rotina de programação
        setContentView(R.layout.personalizando_celulas_em_uma_view)

        listView = findViewById(R.id.listView)

        fab  = findViewById(R.id.fab)
        fab1 = findViewById(R.id.fab1)
        fab2 = findViewById(R.id.fab2)
        
        fab_open = AnimationUtils.loadAnimation(applicationContext, R.anim.fab_open)
        fab_close = AnimationUtils.loadAnimation(applicationContext, R.anim.fab_close)
        rotate_forward = AnimationUtils.loadAnimation(applicationContext, R.anim.rotate_forward)
        rotate_backward = AnimationUtils.loadAnimation(applicationContext, R.anim.rotate_backward)

        fab.setOnClickListener {
            startFabAnimation(0)
        }
        fab1.setOnClickListener {
            startFabAnimation(1)
        }
        fab2.setOnClickListener {
            startFabAnimation(2)
        }
    }

    //-- Inicia a animação dos botões
    fun startFabAnimation(id: Int) {

        when(id) {
            0 -> animateFAB()
            1 -> carregarListView(0)
            2 -> carregarListView(1)
        }
    }

    //-- Executa a animação de acordo com os valores enviandos
    fun animateFAB() {

        if (isFabOpen) {

            fab.startAnimation(rotate_backward)
            fab1.startAnimation(fab_close)
            fab2.startAnimation(fab_close)
            fab1.isClickable = false
            fab2.isClickable = false
            isFabOpen = false

        } else {

            fab.startAnimation(rotate_forward)
            fab1.startAnimation(fab_open)
            fab2.startAnimation(fab_open)
            fab1.isClickable = true
            fab2.isClickable = true
            isFabOpen = true
        }
    }

    //-- Carregando a ListView
    fun carregarListView(option: Int) {

        var jsonArray: JSONArray = DataWarehouse.alunos()

        var details = ArrayList<String>()

        for (item in 0..(jsonArray.length()-1)) {

            var jsonObject: JSONObject = jsonArray.getJSONObject(item)

            var information: String = String()

            if(option ==0) {
                information = jsonObject.getString("name")
            } else {
                information = "rm: " + jsonObject.getString("rm") + " age: " + jsonObject.getString("age")
            }

            details.add(information)
        }

        Collections.sort(details)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, details)
        listView!!.adapter = adapter

        if(option ==0) {
            Toast.makeText(this, "Carregou Lista de Nomes.", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Carregou Lista de RMs e Idades.", Toast.LENGTH_LONG).show();
        }

    }
}
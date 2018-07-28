package br.com.fiap.persistnciadedados._13_4

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import br.com.fiap.persistnciadedados.R
import br.com.fiap.persistnciadedados.data.DataWarehouse
import br.com.fiap.persistnciadedados.data.DataWarehouseModel
import org.json.JSONArray
import org.json.JSONObject
import java.util.*

class Views_personalizadas_com_RecyclerView : AppCompatActivity() {

    //-------------------------------------------------------------------------------------
    private var myViews_personalizadas_com_RecyclerView:        RecyclerView? = null
    private var myViews_personalizadas_com_RecyclerViewAdapter: RecyclerView.Adapter<*>? = null
    var listOfAlunos: ArrayList<DataWarehouseModel> = ArrayList()
    //-------------------------------------------------------------------------------------
    override fun onCreate(savedInstanceState: Bundle?) {
        
        super.onCreate(savedInstanceState)
        setContentView(R.layout.views_personalizadas_com_recyclerview)

        var jsonArray: JSONArray = DataWarehouse.alunos()

        for (item in 0..(jsonArray.length()-1)) {

            var jsonObject: JSONObject = jsonArray.getJSONObject(item)

            val aluno    = DataWarehouseModel()
            aluno.name   = jsonObject.getString("name")
            aluno.age    = jsonObject.getInt("age")
            aluno.rm     = jsonObject.getInt("rm")

            listOfAlunos.add(aluno)
        }

        myViews_personalizadas_com_RecyclerView = findViewById(R.id.recycler_view)

        var mLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        myViews_personalizadas_com_RecyclerView!!.layoutManager = mLayoutManager

        myViews_personalizadas_com_RecyclerViewAdapter = Views_personalizadas_com_RecyclerViewAdapter(listOfAlunos)
        myViews_personalizadas_com_RecyclerView!!.adapter = myViews_personalizadas_com_RecyclerViewAdapter
    }
    //-------------------------------------------------------------------------------------
}
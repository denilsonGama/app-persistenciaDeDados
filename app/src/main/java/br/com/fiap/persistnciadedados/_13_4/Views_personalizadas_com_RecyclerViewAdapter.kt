package br.com.fiap.persistnciadedados._13_4

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import br.com.fiap.persistnciadedados.R
import br.com.fiap.persistnciadedados.data.DataWarehouseModel
import java.util.*

class Views_personalizadas_com_RecyclerViewAdapter(private val mDataList: ArrayList<DataWarehouseModel>) : RecyclerView.Adapter<Views_personalizadas_com_RecyclerViewAdapter.Views_personalizadas_com_RecyclerViewAdapterHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Views_personalizadas_com_RecyclerViewAdapterHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.views_personalizadas_com_recyclerview_item, parent, false)
        return Views_personalizadas_com_RecyclerViewAdapterHolder(view)
    }

    override fun onBindViewHolder(holder: Views_personalizadas_com_RecyclerViewAdapterHolder, position: Int) {
        holder.name.text = mDataList[position].name
        holder.age.text  = "age: " + mDataList[position].age.toString()
        holder.rm.text   = "rm:  " + mDataList[position].rm.toString()
    }

    override fun getItemCount(): Int {
        return mDataList.size
    }

    inner class Views_personalizadas_com_RecyclerViewAdapterHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var name: TextView
        internal var age:  TextView
        internal var rm:   TextView

        init {
            name = itemView.findViewById<View>(R.id.name) as TextView
            age  = itemView.findViewById<View>(R.id.age)  as TextView
            rm   = itemView.findViewById<View>(R.id.rm)   as TextView
        }
    }
}
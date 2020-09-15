package com.example.groupapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(var context: Context, var skillList :ArrayList<String>) : RecyclerView.Adapter<CustomAdapter.MyViewHolder>(){
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.name.text = skillList[position]?: ""
        holder.remove.text = "remove"

        holder.remove.setOnClickListener {
            val item = skillList[position]
            Toast.makeText(context," $item clicked", Toast.LENGTH_LONG).show()
            skillList.removeAt(position)
            this.notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return MyViewHolder(v)
    }
    override fun getItemCount(): Int {
        return skillList.size
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById<TextView>(R.id.name)
        var remove: TextView = itemView.findViewById<TextView>(R.id.delete)
    }
}
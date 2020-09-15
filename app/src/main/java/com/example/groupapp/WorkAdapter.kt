package com.example.groupapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.groupapp.classes.Work

class WorkAdapter(var works: ArrayList<Work>?) : RecyclerView.Adapter<WorkAdapter.MyViewHolder>(){

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.pos.text = works!![position].position.toString()
        //holder.description.text = works!![position].description.toString()
        holder.company.text = works!![position].companyName.toString()
        holder.date.text = works!![position].startDate.toString() + " - " + works!![position].endDate.toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.work_layout, parent, false)
        return MyViewHolder(v)
    }
    override fun getItemCount(): Int {
        return works!!.size
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var pos: TextView = itemView.findViewById<TextView>(R.id.workPosition)
        //var description: TextView = itemView.findViewById<TextView>(R.id.workDescription)
        var company: TextView = itemView.findViewById<TextView>(R.id.workCompany)
        var date: TextView = itemView.findViewById<TextView>(R.id.workDate)
    }
}

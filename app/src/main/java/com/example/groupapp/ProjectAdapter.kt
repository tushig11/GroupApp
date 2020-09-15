package com.example.groupapp

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.groupapp.classes.Project
import java.time.format.DateTimeFormatter

class ProjectAdapter(var projects: ArrayList<Project>?) : RecyclerView.Adapter<ProjectAdapter.MyViewHolder>(){

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.projectName.text =
            projects!![position].projectName.toString() + " at " + projects!![position].company.toString()

        var formatter = DateTimeFormatter.ofPattern("MMM yyyy")

        holder.date.text =
            projects!![position].startDate?.format(formatter) + " - " +
                    projects!![position].endDate?.format(formatter)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.project_layout, parent, false)
        return MyViewHolder(v)
    }
    override fun getItemCount(): Int {
        return projects!!.size
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var projectName: TextView = itemView.findViewById<TextView>(R.id.projectNameAndCompany)
        var date: TextView = itemView.findViewById<TextView>(R.id.projectDate)
    }
}

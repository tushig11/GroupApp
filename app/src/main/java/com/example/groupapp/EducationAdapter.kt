package com.example.groupapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.groupapp.classes.Education
import com.example.groupapp.classes.Work

class EducationAdapter(var educations: ArrayList<Education>?) : RecyclerView.Adapter<EducationAdapter.MyViewHolder>(){

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.major.text = educations!![position].degree.toString() + " of " + educations!![position]?.major.toString()
        holder.school.text = educations!![position].schoolName.toString()
        holder.date.text = educations!![position].startDate.toString() + " - " + educations!![position].endDate.toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.edu_layout, parent, false)
        return MyViewHolder(v)
    }
    override fun getItemCount(): Int {
        return educations!!.size
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var major: TextView = itemView.findViewById<TextView>(R.id.eduMajor)
        var school: TextView = itemView.findViewById<TextView>(R.id.eduSchool)
        var date: TextView = itemView.findViewById<TextView>(R.id.eduDate)
    }
}

package com.example.groupapp

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.groupapp.classes.UserProfile
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = inflater.inflate(R.layout.fragment_home, container, false)
        val gson = Gson()
        val spf = inflater.context.getSharedPreferences("user", 0)
        val response = spf.getString("data", "")
        val testUser = gson.fromJson(response, UserProfile::class.java)
        if( testUser != null){
            val fullName = "${testUser.firstName} ${testUser.lastName}"
            binding.fullName.text = fullName
            binding.title.text = "Full-Stack Engineer"
            val address = "Moline, IL"
            binding.address.text = address
            val experience = "${testUser.totalXP} years of experience"
            binding.totalXP.text = experience
            val image = resources.getIdentifier(testUser.image, "drawable", inflater.context.packageName)
            binding.profilePicture.setImageResource(image)
            binding.skillsView.layoutManager = LinearLayoutManager(binding.context)
            val adapter = CustomAdapter(binding.context, testUser.skills)
            binding.skillsView.adapter = adapter

            binding.fab.setOnClickListener(){
                if(!TextUtils.isEmpty(binding.skillName.text.toString())){
                    testUser.skills.add(binding.skillName.text.toString())
                    adapter.notifyItemInserted(testUser.skills.size)
                }else{
                    Toast.makeText(binding.context, "Enter your skill name first", Toast.LENGTH_SHORT)
                }

            }
        }

        return binding
    }
}
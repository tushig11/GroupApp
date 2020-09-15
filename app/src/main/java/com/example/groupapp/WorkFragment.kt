package com.example.groupapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.groupapp.classes.Education
import com.example.groupapp.classes.UserProfile
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_about.*
import kotlinx.android.synthetic.main.fragment_about.view.*
import kotlinx.android.synthetic.main.fragment_work.view.*

class WorkFragment : Fragment() {
    lateinit var user: UserProfile;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val gson = Gson()
        val spf = inflater.context.getSharedPreferences("user", 0)
        val response = spf.getString("data", "")
        user = gson.fromJson(response, UserProfile::class.java)

        var binding = inflater.inflate(R.layout.fragment_work, container, false)

        binding.worksView.layoutManager = LinearLayoutManager(binding.context)
        binding.worksView.adapter = WorkAdapter(user.works)

        binding.projectsView.layoutManager = LinearLayoutManager(binding.context)
        binding.projectsView.adapter = ProjectAdapter(user.projects)

        return binding
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}
package com.example.groupapp

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.annotation.RequiresApi
import com.example.groupapp.classes.Education
import com.example.groupapp.classes.Project
import com.example.groupapp.classes.UserProfile
import com.example.groupapp.classes.Work
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    @SuppressLint("NewApi")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(HomeFragment(), "Home")
        adapter.addFragment(AboutFragment(), "About")
        adapter.addFragment(WorkFragment(), "Work")
        adapter.addFragment(ContactFragment(), "Contact")

        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)
        toolbar.setTitleTextColor(getColor(R.color.white))
        setSupportActionBar(toolbar)

        createTestUser("Bat", "Bold", arrayListOf("Java", "JavaScript", "Python"), "about")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var selectedTab: Int? = null
        when(item.itemId){
            R.id.main_home -> selectedTab = 0
            R.id.main_about -> selectedTab = 1
            R.id.main_work -> selectedTab = 2
            R.id.main_contact -> selectedTab = 3
            else -> Toast.makeText(applicationContext, item.title.toString(), Toast.LENGTH_SHORT).show()
        }
        if(selectedTab != null) tabs.getTabAt(selectedTab)?.select()
        return super.onOptionsItemSelected(item)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createTestUser(fname:String, lname:String, skills: ArrayList<String>, image: String){
        var testUser = UserProfile(fname, lname, image, skills, 6)

        var bachelor = Education(1, "NUM", LocalDate.of(2014, 9, 1), LocalDate.of(2018, 5, 30), "Bachelor", "Computer Science")
        var master = Education(2, "MUM", LocalDate.of(2019, 2, 4), LocalDate.of(2021, 6, 30), "Master", "Computer Science")
        testUser.educations?.add(bachelor)
        testUser.educations?.add(master)

        testUser.aboutMe = "Well-educated software developer with 4 years of history contributing to full stack design, development, deployment, and testing of web applications and web services, applying SDLC methodologies and object- oriented concepts to create detailed and successful projects. Familiar with in-depth unit and integration testing using frameworks such as Junit and Protractor, as well as relational databases."

        var firstJob = Work(1, "Good company", LocalDate.of(2014, 6, 1), LocalDate.of(2017, 12, 31), "Junior Software Developer", "Contributed to complete web application for online shopping system. Responsible for development of front-end and back-end side using Spring boot, Rest API, Microservices, JS and React, performing unit and integration test.")
        var secondJob = Work(2, "Best company", LocalDate.of(2018, 1, 1), LocalDate.of(2020, 9, 13), "Software Developer", "Contributed to complete web application for online shopping system. Responsible for development of front-end and back-end side using Spring boot, Rest API, Microservices, JS, React and AWS, performing unit and integration test.")
        testUser.works?.add(firstJob)
        testUser.works?.add(secondJob)

        testUser.interests?.add("Dancing")
        testUser.interests?.add("Problem solving")
        testUser.interests?.add("Helping elderly people")

        var proj1 = Project(1, "Developer", "First Super Project", "Good company", LocalDate.of(2014, 12, 31), LocalDate.of(2014, 12, 31))
        var proj2 = Project(2, "Developer", "Second Super Project", "Best company", LocalDate.of(2014, 12, 31), LocalDate.of(2014, 12, 31))
        testUser.projects?.add(proj1)
        testUser.projects?.add(proj2)

        val gson = Gson()
        if( testUser != null){
            val userObject = gson.toJson(testUser)
            val spf = getSharedPreferences("user", 0)
            val edit = spf.edit()
            edit.putString("data", userObject)
            edit.apply()
        }
    }
}
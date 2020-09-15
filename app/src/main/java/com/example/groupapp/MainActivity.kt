package com.example.groupapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.annotation.RequiresApi
import com.example.groupapp.classes.Contact
import com.example.groupapp.classes.UserProfile
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
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
        createContact("3504 North Hamlin avenue Chicago, IL", "571-232-4638","nbjargal@gmail.com", "n.batjargal", "kobebryant" )
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

    private fun createTestUser(fname:String, lname:String, skills: ArrayList<String>, image: String){
        var testUser = UserProfile(fname, lname, image, skills, 6)
        val gson = Gson()
        if( testUser != null){
            val userObject = gson.toJson(testUser)
            val spf = getSharedPreferences("user", 0)
            val edit = spf.edit()
            edit.putString("data", userObject)
            edit.apply()
        }
    }
    private fun createContact(address:String, phone: String, email:String, facebook:String, twitter:String) {
        var contact = Contact(address, phone, email, facebook, twitter)
        val gson = Gson()
        if(contact != null) {
            val contactObj = gson.toJson(contact)
            val sp = getSharedPreferences("contact", 0)
            val edit = sp.edit()
            edit.putString("contactUser", contactObj)
            edit.apply()
        }
    }
}
package com.example.groupapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.annotation.RequiresApi
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
}
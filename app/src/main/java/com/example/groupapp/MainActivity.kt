package com.example.groupapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
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

        setSupportActionBar(toolbar)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Toast.makeText(applicationContext, item.title.toString(), Toast.LENGTH_SHORT).show()
        when(item.itemId){
            R.id.main_home -> tabs.getTabAt(0)?.select();
            R.id.main_about -> tabs.getTabAt(1)?.select();
            R.id.main_work -> tabs.getTabAt(2)?.select();
            R.id.main_contact -> tabs.getTabAt(3)?.select();
        }
        return super.onOptionsItemSelected(item)
    }
}
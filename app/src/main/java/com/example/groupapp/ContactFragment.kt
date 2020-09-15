package com.example.groupapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.groupapp.classes.Contact
import com.example.groupapp.classes.UserProfile
import kotlinx.android.synthetic.main.fragment_contact.*
import kotlinx.android.synthetic.main.fragment_contact.view.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.fragment_home.view.address

class ContactFragment : Fragment() {

    private fun webHandler(url: String) {
        val intent = Intent(activity, WebActivity::class.java)
        val bundle = Bundle()
        bundle.putString("url", url)
        intent.putExtras(bundle)
        startActivity(intent)
    }

    private fun phoneHandler(number: String) {
        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:"+number))
        startActivity(intent)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = inflater.inflate(R.layout.fragment_contact, container, false)
        val gson = Gson()
        val spf = inflater.context.getSharedPreferences("contact", 0)
        val response = spf.getString("data", "")
        val testUser = gson.fromJson(response, Contact::class.java)
        if( testUser != null) {
            binding.address.text = testUser.address
            binding.phone.text = testUser.phone
            binding.email.text = testUser.email
            binding.facebook.setOnClickListener { webHandler("https://www.facebook.com/${testUser.facebook}") }
            binding.twitter.setOnClickListener { webHandler("https://www.twitter.com/${testUser.twitter}") }
        }
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }
}

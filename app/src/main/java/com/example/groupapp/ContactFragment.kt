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
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+number))
        startActivity(intent)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let{


//            val gson = Gson()
//            val spf = inflater.context.getSharedPreferences("user", 0)
//            val response = spf.getString("data", "")
//            val testUser = gson.fromJson(response, UserProfile::class.java)

            val spf = activity?.getSharedPreferences("user", 0)
            val response = spf?.getString("data", "") ?: ""
            if( response.isNotEmpty()) {
                val user = Gson().fromJson(response, UserProfile::class.java)
                val contact = user.contact
                address.text = contact.address
                phone.text = contact.phone
                email.text = contact.email
                facebook.setOnClickListener { webHandler("https://www.facebook.com/${contact.facebook}") }
                twitter.setOnClickListener { webHandler("https://www.twitter.com/${contact.twitter}") }
                phone.setOnClickListener { phoneHandler(contact.phone) }
            }
        }

    }
}

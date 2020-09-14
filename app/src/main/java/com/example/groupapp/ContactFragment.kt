package com.example.groupapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_contact.*

class ContactFragment : Fragment() {

    private fun webHandler(url: String) {
        val intent = Intent(activity, WebActivity::class.java)
        val bundle = Bundle()
        bundle.putString("url", url)
//        intent.putExtra("url", url)
        intent.putExtras(bundle)
        activity?.startActivity(intent)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        facebook.setOnClickListener {
            webHandler("https://www.facebook.com/n.batjargal")
        }
        twitter.setOnClickListener {
            webHandler("https://www.twitter.com")
        }
    }
}

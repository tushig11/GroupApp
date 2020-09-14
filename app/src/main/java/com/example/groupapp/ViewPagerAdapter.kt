package com.example.groupapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class ViewPagerAdapter( manager: FragmentManager): FragmentStatePagerAdapter(manager){
    private val mFragmentList = ArrayList<Fragment>()
    private val mFragmentTitleList = ArrayList<String>()

    override fun getItem(position: Int) = mFragmentList[position]

    override fun getPageTitle(position: Int) = mFragmentTitleList[position]

    fun addFragment(fragment: Fragment, title: String) {
        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)
    }

    override fun getCount() = mFragmentList.size

}
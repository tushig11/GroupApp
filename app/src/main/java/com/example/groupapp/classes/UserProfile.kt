package com.example.groupapp.classes

import java.io.Serializable

data class UserProfile(var firstName: String, var lastName: String): Serializable{
    var skills: ArrayList<String> = ArrayList<String>()
    var image: String? = null
    var totalXP: Int? = null
    constructor(firstName: String, lastName: String, image: String, skills:ArrayList<String>, totalXP: Int):this(firstName,lastName){
        this.skills = skills
        this.image = image
        this.totalXP == totalXP
    }

    fun addSkill(newSkill: String){
        skills.add(newSkill)
    }

    fun removeSkill(index: Int){
        skills = skills.toMutableList().apply {
            removeAt(index)
        } as ArrayList<String>
    }

}
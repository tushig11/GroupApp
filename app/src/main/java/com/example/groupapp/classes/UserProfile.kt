package com.example.groupapp.classes

import java.io.Serializable

data class UserProfile(var firstName: String, var lastName: String): Serializable{
    var skills: ArrayList<String> = ArrayList<String>()
    var image: String? = null
    var totalXP: Int? = null
    var aboutMe: String? = null

    lateinit var contact: Contact
    var educations: ArrayList<Education>? = null
    var interests: ArrayList<String>? = null
    var works: ArrayList<Work>?= null
    var projects: ArrayList<Project>?= null

    constructor(firstName: String, lastName: String, image: String, skills:ArrayList<String>, totalXP: Int, contact: Contact):this(firstName,lastName){
        this.skills = skills
        this.image = image
        this.totalXP = totalXP
        this.contact = contact
        this.educations = ArrayList<Education>()
        this.interests = ArrayList<String>()
        this.works = ArrayList<Work>()
        this.projects = ArrayList<Project>()
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
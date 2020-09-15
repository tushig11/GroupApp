package com.example.groupapp.classes

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.time.LocalDate
import java.util.*

data class Project(
    @SerializedName("pId")
    var pId: Int?,
    @SerializedName("role")
    var role: String?,
    @SerializedName("projectName")
    var projectName: String?,
    @SerializedName("company")
    var company: String?,
    @SerializedName("startDate")
    var startDate: LocalDate?,
    @SerializedName("endDate")
    var endDate: LocalDate?
) : Serializable {}

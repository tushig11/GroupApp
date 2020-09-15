package com.example.groupapp.classes

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.time.LocalDate
import java.util.*

data class Education(
    @SerializedName("eduId")
    var eduId: Int?,
    @SerializedName("schoolName")
    var schoolName: String?,
    @SerializedName("startDate")
    var startDate: LocalDate?,
    @SerializedName("endDate")
    var endDate: LocalDate?,
    @SerializedName("degree")
    var degree: String?,
    @SerializedName("major")
    var major: String?
) : Serializable {}
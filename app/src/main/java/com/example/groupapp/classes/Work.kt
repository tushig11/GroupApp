package com.example.groupapp.classes

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.time.LocalDate
import java.util.*

data class Work(
    @SerializedName("workId")
    var workId: Int?,
    @SerializedName("companyName")
    var companyName: String?,
    @SerializedName("startDate")
    var startDate: LocalDate?,
    @SerializedName("endDate")
    var endDate: LocalDate?,
    @SerializedName("position")
    var position: String?,
    @SerializedName("description")
    var description: String?
) : Serializable {}
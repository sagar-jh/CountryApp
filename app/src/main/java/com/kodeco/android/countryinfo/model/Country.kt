package com.kodeco.android.countryinfo.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)

data class Country(
    @field:Json(name="name")
    var name:CountryName,
    @field:Json(name="capital")
    var capital:List<String>?,
    @field:Json(name="population")
    var population:Long,
    @field:Json(name="area")
    var area:Double,
    @field:Json(name="flags")
    var flags:CountryFlags)


package com.kodeco.android.countryinfo.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CountryFlags(
    @field:Json(name="png")
    var png:String) {
}

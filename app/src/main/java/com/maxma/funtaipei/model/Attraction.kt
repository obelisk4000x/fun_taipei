package com.maxma.funtaipei.model

import java.io.Serializable

data class Attraction(
    val id: Int,
    val name: String,
    val name_zh: String,
    val open_status: Int,
    val introduction: String,
    val open_time: String,
    val zipcode: String,
    val distric: String,
    val address: String,
    val tel: String
) : Serializable {

}
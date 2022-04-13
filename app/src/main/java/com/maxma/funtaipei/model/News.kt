package com.maxma.funtaipei.model

import java.io.Serializable

data class News(
    val id: Int,
    val title: String,
    val description: String,
    val begin: Int,
    val end: String,
    val posted: String
) : Serializable {

}
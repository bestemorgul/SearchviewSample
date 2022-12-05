package com.bestemorgul.searchviewsample

data class FoodModel (
    val title:String,
    val image: Int,
    val description:String,
    var isExpandable: Boolean = false )
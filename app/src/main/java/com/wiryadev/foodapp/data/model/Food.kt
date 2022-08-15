package com.wiryadev.foodapp.data.model

import androidx.annotation.DrawableRes
import com.wiryadev.foodapp.R

data class Food(
    @DrawableRes val image: Int,
    val name: String,
    val type: String,
    val rating: Double,
    val price: Double,
    val description: String,
)

val dummyFoods = listOf(
    Food(
        image = R.drawable.food_orange,
        name = "Orange Asem",
        type = "Healthy",
        rating = 4.5,
        price = 808.00,
        description = "Makanan asal Bandung dengan tekstur yang lembut sehingga ketika dimakan rasanya tidak sakit tenggorokan.",
    ),
    Food(
        image = R.drawable.food_gyoza,
        name = "Gyoza Sapi",
        type = "Meal",
        rating = 4.8,
        price = 808.00,
        description = "Makanan asal Bandung dengan tekstur yang lembut sehingga ketika dimakan rasanya tidak sakit tenggorokan.",
    ),
    Food(
        image = R.drawable.food_avocado,
        name = "Avocado Salad",
        type = "Healthy",
        rating = 4.3,
        price = 808.00,
        description = "Makanan asal Bandung dengan tekstur yang lembut sehingga ketika dimakan rasanya tidak sakit tenggorokan.",
    ),
)
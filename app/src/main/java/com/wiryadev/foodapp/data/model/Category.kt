package com.wiryadev.foodapp.data.model

import androidx.annotation.DrawableRes
import com.wiryadev.foodapp.R

data class Category(
    val name: String,
    @DrawableRes val icon: Int,
)

val dummyCategories = listOf(
    Category("Bread", R.drawable.cate_bread),
    Category("Healthy", R.drawable.cate_carrot),
    Category("Sweets", R.drawable.cate_donut),
)

package com.example.projectone

import androidx.annotation.StringRes

data class Recipe(@StringRes val textResId: Int, val mainIngredient: String, val description: String) {
}

package com.example.projectone

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "RecipeViewModel"

class RecipeViewModel: ViewModel() {


    val recipeBank = listOf(
        Recipe(R.string.recipe_name_goes_here, "Rice","This describes how to make a recipe with rice"),
        Recipe(R.string.jambalaya, "Rice", "Start some rice in your rice cooker, or prepare rice to your preferred method. Saute the vegetables on medium high and then mix the cooked rice with the vegetables"),
        Recipe(R.string.pasta, "Corn", "This pasta has corn in it."),
        Recipe(R.string.chicken_and_waffles, "Chicken", "Cook waffles. Put fried chicked in between two waffles! "),
        Recipe(R.string.useless_recipe, "Corn", "Useless Recipe with some corn in it"),
        Recipe(R.string.bread, "Flour", "Preheat oven to a certain temperature. Mix flour and other stuff and let it rise then cook it and you have bread"),
        Recipe(R.string.french_toast, "Eggs", "Beat eggs, add cinnamon, then you can dip in the bread and cook on a skillet or griddle!"))

    var currentIndex = 0


    val currentRecipeDescription: String
        get() = recipeBank[currentIndex].description

    val currentRecipeName: Int
        get() = recipeBank[currentIndex].textResId

    fun moveToNext() {
        currentIndex = (currentIndex + 1) % recipeBank.size
    }

    fun moveToPrev() {
        if(currentIndex == 0) {
            currentIndex = recipeBank.size
        }
        currentIndex = (currentIndex - 1)
    }

    init {
        Log.d(TAG, "ViewModel Created.")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "ViewModel instance about to be destroyed.")
    }
}
package com.example.projectone

import android.content.ClipDescription
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

private const val MAIN_INGREDIENT = "com.example.projectone.main_ingredient"
private const val TAG = "RecipieShower"

class RecipeShower : AppCompatActivity() {

    private var myIngredient = "default"
    private val recipeViewModel: RecipeViewModel by lazy {
        ViewModelProviders.of(this).get(RecipeViewModel::class.java)
    }

    private lateinit var nextButton: Button
    private lateinit var previousButton: Button
    private lateinit var recipeName: TextView
    private lateinit var recipeDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_shower)

        val myIngredient = intent.getStringExtra(MAIN_INGREDIENT).toString()

        nextButton = findViewById(R.id.next_button)
        previousButton = findViewById(R.id.previous_button)
        recipeName = findViewById(R.id.recipe_name)
        recipeDescription = findViewById(R.id.recipe_description)

        var i = 0
        recipeViewModel.currentIndex = 2
        for (recipe in recipeViewModel.recipeBank) {
            if (recipe.mainIngredient == myIngredient) {
                recipeViewModel.currentIndex = i
            }
            i += 1
        }



        updateRecipe()

        nextButton.setOnClickListener {
            recipeViewModel.moveToNext()
            updateRecipe()
        }

        previousButton.setOnClickListener {
            recipeViewModel.moveToPrev()
            updateRecipe()
        }


    }

    private fun updateRecipe() {
        val recipeTextResId = recipeViewModel.currentRecipeName
        recipeName.setText(recipeTextResId)
        recipeDescription.text = recipeViewModel.currentRecipeDescription
    }

    companion object {
        fun newIntent(packageContext: Context, mainIngredient: String): Intent {
            return Intent(packageContext, RecipeShower::class.java).apply {
                putExtra(MAIN_INGREDIENT, mainIngredient)
            }
        }
    }
}
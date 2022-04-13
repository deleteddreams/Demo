package com.example.demo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    var categories: ArrayList<Category> = ArrayList()
    var restaurants: ArrayList<Restaurant> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val rvCategories = findViewById<View>(R.id.rv_categories) as RecyclerView
        categories.add(Category(R.drawable.pizza, "Italian"))
        categories.add(Category(R.drawable.soup, "Lebanese"))
        categories.add(Category(R.drawable.burger, "German"))
        val categoriesAdapter = CategoriesAdapter(categories)
        rvCategories.adapter = categoriesAdapter
        val layoutManagerCat =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.layoutManager = layoutManagerCat


        val rvRestaurants = findViewById<View>(R.id.rv_restaurants) as RecyclerView
        restaurants.add(Restaurant(R.drawable.restaurant_one, "Piccola Cucina", "583 Lilac St.", "Massapequa, NY 11758"))
        restaurants.add(Restaurant(R.drawable.restaurant_two, "Empire strek House", "583 Lilac St.", "Massapequa, NY 11758"))
        val restaurantsAdapter = RestaurantsAdapter(restaurants)
        rvRestaurants.adapter = restaurantsAdapter
        val layoutManagerRes =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvRestaurants.layoutManager = layoutManagerRes
    }
}
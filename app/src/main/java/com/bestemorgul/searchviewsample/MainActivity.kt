package com.bestemorgul.searchviewsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var foodList = ArrayList<FoodModel>()
    private lateinit var adapter: FoodAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        addDataToList()
        adapter= FoodAdapter(foodList)
        recyclerView.adapter = adapter

        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

    })
    }

    private fun filterList(query: String?) {

        if (query != null) {
            val filteredList = ArrayList<FoodModel>()
            for (i in foodList) {
                if (i.title.lowercase(Locale.ROOT).contains(query)) {
                    filteredList.add(i)
                }
            }

            if (filteredList.isEmpty()) {
                Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show()
            }else {
                adapter.setFilteredList(filteredList)

            }
        }

    }

    private fun addDataToList() {
        foodList.add(FoodModel("Hamburger", R.drawable.hamburger))
        foodList.add(FoodModel("Pizza", R.drawable.pizza))
        foodList.add(FoodModel("French Fries", R.drawable.frenchfries))
        foodList.add(FoodModel("Hotdog", R.drawable.hotdog))
        foodList.add(FoodModel("Macaron", R.drawable.macaron))
        foodList.add(FoodModel("Pancake", R.drawable.pancake))
        foodList.add(FoodModel("Spaghetti", R.drawable.spaghetti))
        foodList.add(FoodModel("Noodle", R.drawable.noodle))
        foodList.add(FoodModel("Tomato Soup", R.drawable.tomatosoup))
        foodList.add(FoodModel("Salad", R.drawable.salad))
        foodList.add(FoodModel("Cereal", R.drawable.cereal))
        foodList.add(FoodModel("Cake", R.drawable.cake))
        foodList.add(FoodModel("Tiramisu", R.drawable.tiramisu))
        foodList.add(FoodModel("Cupcake", R.drawable.cupcake))
        foodList.add(FoodModel("Ice Cream", R.drawable.icecream))
        foodList.add(FoodModel("Avocado Toast", R.drawable.avocadotoast))
        foodList.add(FoodModel("Risotto", R.drawable.risotto))
        foodList.add(FoodModel("Chocolate", R.drawable.chocolate))

    }
}
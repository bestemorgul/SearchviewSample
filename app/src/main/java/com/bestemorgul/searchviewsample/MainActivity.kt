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
        foodList.add(FoodModel("Hamburger",
            R.drawable.hamburger,
            "\tA hamburger, or simply burger, is a food consisting of fillings—usually a patty of ground meat, typically beef—placed inside a sliced bun or bread roll."))
        foodList.add(FoodModel("Pizza",
            R.drawable.pizza,
        "\tPizza is a dish of Italian origin consisting of a usually round, flat base of leavened wheat-based dough topped with tomatoes, cheese, and often various other ingredients (such as various types of sausage, anchovies, mushrooms, onions, olives, vegetables, meat, ham, etc.), which is then baked at a high temperature, traditionally in a wood-fired oven."))
        foodList.add(FoodModel("French Fries",
            R.drawable.frenchfries,
        "\tFrench fries (North American English), chips (British English), finger chips (Indian English), french-fried potatoes, or simply fries, are batonnet or allumette-cut deep-fried potatoes of disputed origin from Belgium and France."))
        foodList.add(FoodModel("Hot Dog",
            R.drawable.hotdog,
            "\tA hot dog (uncommonly spelled hotdog) is a food consisting of a grilled or steamed sausage served in the slit of a partially sliced bun."))
        foodList.add(FoodModel("Macaron",
            R.drawable.macaron,
        "\tA macaron or French macaroon is a sweet meringue-based confection made with egg white, icing sugar, granulated sugar, almond meal, and food colouring."))
        foodList.add(FoodModel("Pancake",
            R.drawable.pancake,
        "\tA pancake (or hot-cake, griddlecake, or flapjack) is a flat cake, often thin and round, prepared from a starch-based batter that may contain eggs, milk and butter and cooked on a hot surface such as a griddle or frying pan, often frying with oil or butter."))
        foodList.add(FoodModel("Spaghetti",
            R.drawable.spaghetti,
        "\tSpaghetti is a long, thin, solid, cylindrical pasta.It is a staple food of traditional Italian cuisine. Like other pasta, spaghetti is made of milled wheat and water and sometimes enriched with vitamins and minerals."))
        foodList.add(FoodModel("Noodle",
            R.drawable.noodle,
        "\tNoodles are a type of food made from unleavened dough which is either rolled flat and cut, stretched, or extruded, into long strips or strings."))
        foodList.add(FoodModel("Tomato Soup",
            R.drawable.tomatosoup,
        "\tTomato soup is a soup with tomatoes as the primary ingredient. It can be served hot or cold, and may be made in a variety of ways.It may be smooth in texture, and there are also recipes that include chunks of tomato, cream, chicken or vegetable stock, vermicelli, chunks of other vegetables and meatballs."))
        foodList.add(FoodModel("Salad",
            R.drawable.salad,
        "\tA salad is a dish consisting of mixed, mostly natural ingredients with at least one raw ingredient. They are often dressed, and typically served at room temperature or chilled, though some can be served warm."))
        foodList.add(FoodModel("Cereal",
            R.drawable.cereal,
        "\tA cereal is any grass cultivated for the edible components of its grain (botanically, a type of fruit called a caryopsis), composed of the endosperm, germ, and bran."))
        foodList.add(FoodModel("Cake",
            R.drawable.cake,
        "\tCake is a flour confection made from flour, sugar, and other ingredients, and is usually baked. In their oldest forms, cakes were modifications of bread, but cakes now cover a wide range of preparations that can be simple or elaborate, and which share features with desserts such as pastries, meringues, custards, and pies."))
        foodList.add(FoodModel("Tiramisu",
            R.drawable.tiramisu,
        "\tTiramisu is a coffee-flavoured Italian dessert. It is made of ladyfingers (savoiardi) dipped in coffee, layered with a whipped mixture of eggs, sugar, and mascarpone cheese, flavoured with cocoa."))
        foodList.add(FoodModel("Cupcake",
            R.drawable.cupcake,
        "\tA cupcake is a small cake designed to serve one person, which may be baked in a small thin paper or aluminum cup."))
        foodList.add(FoodModel("Ice Cream",
            R.drawable.icecream,
        "\tIce cream is a sweetened frozen food typically eaten as a snack or dessert. It may be made from milk or cream and is flavoured with a sweetener, either sugar or an alternative, and a spice, such as cocoa or vanilla, or with fruit such as strawberries or peaches."))
        foodList.add(FoodModel("Avocado Toast",
            R.drawable.avocadotoast,
        "\tAvocado toast is a type of open sandwich consisting of toast with mashed avocado, and usually salt, black pepper, and sometimes citrus juice. Ingredients added to enhance the flavor include olive oil, hummus, red pepper flakes, feta, dukkah and tomato."))
        foodList.add(FoodModel("Risotto",
            R.drawable.risotto,
        "\tRisotto is a northern Italian rice dish cooked with broth until it reaches a creamy consistency. The broth can be derived from meat, fish, or vegetables. Many types of risotto contain butter, onion, white wine, and Parmigiano-Reggiano. It is one of the most common ways of cooking rice in Italy."))
        foodList.add(FoodModel("Chocolate",
            R.drawable.chocolate,
        "\tChocolate is a food made from roasted and ground cacao seed kernels that is available as a liquid, solid, or paste, either on its own or as a flavoring agent in other foods."))
    }
}
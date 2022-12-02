package com.bestemorgul.searchviewsample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FoodAdapter(var foodList: List<FoodModel>) :
    RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

        inner class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val foodImage : ImageView = itemView.findViewById(R.id.foodImg)
            val foodTitle : TextView = itemView.findViewById(R.id.titleTv)

        }

    fun setFilteredList (foodList: List<FoodModel>) {
        this.foodList = foodList
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_design, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.foodImage.setImageResource(foodList[position].image)
        holder.foodTitle.text = foodList[position].title
    }

    override fun getItemCount(): Int {
       return foodList.size
    }


}

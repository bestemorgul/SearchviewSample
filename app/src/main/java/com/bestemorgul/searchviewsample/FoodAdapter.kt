package com.bestemorgul.searchviewsample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class FoodAdapter(private var foodList: List<FoodModel>) :
    RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

        inner class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val foodImage : ImageView = itemView.findViewById(R.id.foodImg)
            val foodTitle : TextView = itemView.findViewById(R.id.titleTv)
            val foodDesc : TextView = itemView.findViewById(R.id.foodDesc)
            val constraintLayout : ConstraintLayout = itemView.findViewById(R.id.constraintLayout)
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
        val foodData = foodList[position]
        holder.foodImage.setImageResource(foodData.image)
        holder.foodTitle.text = foodData.title
        holder.foodDesc.text = foodData.description

        val isExpandable : Boolean = foodData.isExpandable
        holder.foodDesc.visibility = if(isExpandable) View.VISIBLE else View.GONE

        holder.constraintLayout.setOnClickListener {
            foodData.isExpandable = !foodData.isExpandable
            notifyItemChanged(position)
        }
    }

    override fun getItemCount(): Int {
       return foodList.size
    }


}

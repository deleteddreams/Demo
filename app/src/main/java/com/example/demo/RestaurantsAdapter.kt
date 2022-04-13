package com.example.demo

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class RestaurantsAdapter (private val mRestaurants: List<Restaurant>): RecyclerView.Adapter<RestaurantsAdapter.ViewHolder>() {
    var context: Context? = null;
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantsAdapter.ViewHolder {
        context = parent.context
        val inflater = LayoutInflater.from(context)
        val restaurantView = inflater.inflate(R.layout.rv_res_item, parent, false)
        return ViewHolder(restaurantView)
    }

    override fun onBindViewHolder(viewHolder: RestaurantsAdapter.ViewHolder, position: Int) {
        val restaurant: Restaurant = mRestaurants.get(position)
        val image = viewHolder.resImage
        image.setImageResource(restaurant.imageID)
        val textViewName = viewHolder.resName
        textViewName.setText(restaurant.name)
        val textViewAddOne = viewHolder.resAddOne
        textViewAddOne.setText(restaurant.addressOne)
        val textViewAddTwo = viewHolder.resAddTwo
        textViewAddTwo.setText(restaurant.addressTwo)
    }

    override fun getItemCount(): Int {
        return mRestaurants.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val resImage = itemView.findViewById<ImageView>(R.id.res_item_image)
        val resName = itemView.findViewById<TextView>(R.id.res_item_name)
        val resAddOne = itemView.findViewById<TextView>(R.id.res_item_address_one)
        val resAddTwo = itemView.findViewById<TextView>(R.id.res_item_address_two)
    }
}
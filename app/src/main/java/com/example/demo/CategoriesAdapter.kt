package com.example.demo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class CategoriesAdapter (private val mCategories: List<Category>): RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {
    var context: Context? = null;
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesAdapter.ViewHolder {
        context = parent.context
        val inflater = LayoutInflater.from(context)
        val categoryView = inflater.inflate(R.layout.rv_cat_item, parent, false)
        return ViewHolder(categoryView)
    }

    override fun onBindViewHolder(viewHolder: CategoriesAdapter.ViewHolder, position: Int) {
        val category: Category = mCategories.get(position)
        val image = viewHolder.catImage
        image.setImageResource(category.imageID)
        val textView = viewHolder.catDesc
        textView.setText(category.name)
        var cardView = viewHolder.catCard

        if (position == 0){
            cardView.setCardBackgroundColor(context?.getResources()?.getColor(R.color.colorItalian)!!)
        } else if (position == 1){
            cardView.setCardBackgroundColor(context?.getResources()?.getColor(R.color.colorLebanese)!!)
        } else if (position == 2){
            cardView.setCardBackgroundColor(context?.getResources()?.getColor(R.color.colorGerman)!!)
        }
    }

    override fun getItemCount(): Int {
        return mCategories.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val catCard = itemView.findViewById<CardView>(R.id.cat_item)
        val catImage = itemView.findViewById<ImageView>(R.id.cat_item_image)
        val catDesc = itemView.findViewById<TextView>(R.id.cat_item_desc)
    }
}
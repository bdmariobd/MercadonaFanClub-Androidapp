package com.bdmariobd.mercadonafc.activities.shoppingCart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.bdmariobd.mercadonafc.R

class ShoppingCartAdapter : RecyclerView.Adapter<ShoppingCartAdapter.ShoppingCartViewHolder>()
{
    private val items = ArrayList<String>( )

    fun setItems(items: List<String>)
    {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingCartViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.shopping_cart_item, parent, false)
        return ShoppingCartViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ShoppingCartViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class ShoppingCartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)    {
        private val checkBox: CheckBox = itemView.findViewById(R.id.checkBox)

        fun bind(item: String)
        {
            checkBox.text = item
            checkBox.isChecked = false
        }
    }
}
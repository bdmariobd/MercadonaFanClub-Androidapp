package com.bdmariobd.mercadonafc.activities.shoppingCart

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bdmariobd.mercadonafc.R

class ShoppingCart : AppCompatActivity() {
    private val shoppingCartAdapter = ShoppingCartAdapter()
    private lateinit var shoppingCartRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_cart)
        this.shoppingCartRecyclerView = findViewById(R.id.shoppingCartRV)
        this.shoppingCartRecyclerView.layoutManager = (LinearLayoutManager(this))
        this.shoppingCartRecyclerView.setHasFixedSize(true)
        this.shoppingCartRecyclerView.addItemDecoration(DividerItemDecoration(this, this.shoppingCartRecyclerView.layoutManager?.let { (it as LinearLayoutManager).orientation }!!))
        this.shoppingCartAdapter.setItems(listOf("Item 3", "Item 2", "Item 3", "Item 4", "Item 5"))
        this.shoppingCartRecyclerView.adapter = this.shoppingCartAdapter

    }
}
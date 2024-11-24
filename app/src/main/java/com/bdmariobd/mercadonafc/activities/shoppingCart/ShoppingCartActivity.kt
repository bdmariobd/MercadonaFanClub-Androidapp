package com.bdmariobd.mercadonafc.activities.shoppingCart

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bdmariobd.mercadonafc.R
import com.bdmariobd.mercadonafc.integration.ShoppingCartEntity
import com.bdmariobd.mercadonafc.model.ShoppingCartViewModel
import kotlinx.coroutines.launch

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingCartActivity : AppCompatActivity() {
    private val shoppingCartAdapter = ShoppingCartAdapter()
    private lateinit var shoppingCartRecyclerView: RecyclerView
    private val shoppingCartViewModel: ShoppingCartViewModel by lazy {
        ViewModelProvider(this)[ShoppingCartViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_cart)

        // Set up RecyclerView
        shoppingCartRecyclerView = findViewById(R.id.shoppingCartRV)
        shoppingCartRecyclerView.layoutManager = LinearLayoutManager(this)
        shoppingCartRecyclerView.setHasFixedSize(true)
        shoppingCartRecyclerView.addItemDecoration(
            DividerItemDecoration(
                this,
                (shoppingCartRecyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        shoppingCartRecyclerView.adapter = shoppingCartAdapter

        // Observe LiveData from ViewModel
        shoppingCartViewModel.getItems().observe(this) { items ->
            items?.let {
                shoppingCartAdapter.setItems(it.map { item -> item.name }) // Update RecyclerView
            }
        }

        // Button to add new items
        val addItemToShoppingCartButton: Button = findViewById(R.id.addNewItemToCartButton)
        addItemToShoppingCartButton.setOnClickListener {
            // Launch a coroutine inside the lifecycleScope to run addNewItem() in the background
                addNewItem()
        }
    }

    // Function to add a new item via ViewModel
    private fun addNewItem() {
        // Create a new item and insert it through the ViewModel
        val newItem = ShoppingCartEntity(
            name = "Item 6",
            isCheck = false,
            price = null, // Adjust price if necessary
            product = null // Adjust product if necessary
        )

        // Insert the new item into the repository via the ViewModel
        shoppingCartViewModel.insertItem(newItem)
    }
}


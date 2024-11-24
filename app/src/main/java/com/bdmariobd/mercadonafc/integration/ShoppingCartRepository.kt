package com.bdmariobd.mercadonafc.integration

import android.content.Context
import androidx.lifecycle.LiveData

class ShoppingCartRepository(context: Context) {
    private val shoppingCartDAO: ShoppingCartDAO
    private var allItems: LiveData<List<ShoppingCartEntity>>? = null

    init {
        val db = ShoppingCartRoomDatabase.getDatabase(context)
        shoppingCartDAO = db.shoppingCartDAO()
        allItems = shoppingCartDAO.getItems()  // getItems() already returns LiveData
    }

    fun getItems(): LiveData<List<ShoppingCartEntity>> {
        return allItems!!
    }

    // These methods perform database operations, so they should be suspend functions
     fun insertItem(item: ShoppingCartEntity) {
        shoppingCartDAO.insertItem(item)
    }

     fun deleteItem(item: String) {
        shoppingCartDAO.deleteItem(item)
    }

     fun updateItem(item: ShoppingCartEntity) {
        shoppingCartDAO.updateItem(item)
    }

     fun clearItems() {
        shoppingCartDAO.clearItems()
    }
}

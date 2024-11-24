package com.bdmariobd.mercadonafc.model

import com.bdmariobd.mercadonafc.integration.ShoppingCartEntity
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.bdmariobd.mercadonafc.integration.ShoppingCartRepository

import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingCartViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ShoppingCartRepository = ShoppingCartRepository(application)
    private val allItems: LiveData<List<ShoppingCartEntity>> = repository.getItems()

    // Get items from the repository (no change)
    fun getItems(): LiveData<List<ShoppingCartEntity>> {
        return allItems
    }

    // Insert item using a coroutine on a background thread
    fun insertItem(item: ShoppingCartEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertItem(item)
        }
    }

    // Delete item using a coroutine on a background thread
    fun deleteItem(item: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteItem(item)
        }
    }

    // Update item using a coroutine on a background thread
    fun updateItem(item: ShoppingCartEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateItem(item)
        }
    }

    // Clear all items using a coroutine on a background thread
    fun clearItems() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.clearItems()
        }
    }
}


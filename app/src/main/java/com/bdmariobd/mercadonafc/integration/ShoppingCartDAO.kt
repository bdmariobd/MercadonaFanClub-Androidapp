package com.bdmariobd.mercadonafc.integration

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ShoppingCartDAO {

    @Query("SELECT * FROM shopping_cart_database")
    fun getItems(): LiveData<List<ShoppingCartEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItem(item: ShoppingCartEntity)

    @Query("DELETE FROM shopping_cart_database WHERE id = :itemId")
    fun deleteItem(itemId: String)

    @Update
    fun updateItem(item: ShoppingCartEntity)

    @Query("DELETE FROM shopping_cart_database")
    fun clearItems()
}

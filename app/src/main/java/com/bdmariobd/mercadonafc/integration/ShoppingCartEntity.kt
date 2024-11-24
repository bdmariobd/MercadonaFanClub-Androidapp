package com.bdmariobd.mercadonafc.integration

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bdmariobd.mercadonafc.models.Product

@Entity(tableName = "shopping_cart_database")
data class ShoppingCartEntity(
   @PrimaryKey(autoGenerate = true) val id: Int = 0, // Primary key should not be nullable
   val name: String,
   val isCheck: Boolean,
   val price: Int?, // Keep price nullable if it's optional
   val product: Product? // Embed the Product object
)

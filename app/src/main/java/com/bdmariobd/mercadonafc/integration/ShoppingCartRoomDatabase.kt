package com.bdmariobd.mercadonafc.integration

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.bdmariobd.mercadonafc.models.Product
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Database(entities = [ShoppingCartEntity::class], version = 2, exportSchema = false)
@TypeConverters(Converters::class)
abstract class ShoppingCartRoomDatabase : RoomDatabase() {

    abstract fun shoppingCartDAO(): ShoppingCartDAO

    companion object {
        @Volatile
        private var INSTANCE: ShoppingCartRoomDatabase? = null

        fun getDatabase(context: Context): ShoppingCartRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ShoppingCartRoomDatabase::class.java,
                    "shopping_cart_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}

class Converters {

    // Convert the entire Product object to JSON string
    @TypeConverter
    fun fromProduct(product: Product?): String? {
        if (product == null) return null
        return Gson().toJson(product)  // Converts the Product object to JSON
    }

    // Convert JSON string back to the Product object
    @TypeConverter
    fun toProduct(productJson: String?): Product? {
        if (productJson == null) return null
        val type = object : TypeToken<Product>() {}.type
        return Gson().fromJson(productJson, type)  // Converts the JSON back to a Product object
    }
}

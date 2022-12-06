package com.codinginflow.testproject.repositories

import androidx.lifecycle.LiveData
import com.codinginflow.testproject.util.Resource
import com.codinginflow.testproject.data.local.ShoppingItem
import com.codinginflow.testproject.data.remote.responses.ImageResponse

interface ShoppingRepository {

    suspend fun insertShoppingItem(shoppingItem: ShoppingItem)

    suspend fun deleteShoppingItem(shoppingItem: ShoppingItem)

    fun observeAllShoppingItems(): LiveData<List<ShoppingItem>>

    fun observeTotalPrice(): LiveData<Float>

    suspend fun searchForImage(imageQuery: String): Resource<ImageResponse>
}
package com.lezinaM.shoppinglist.domain

import androidx.lifecycle.LiveData

interface ShoppingListRepository {

    fun addShopItem (shopItem: ShopItem)
    fun deleteShopItem (shopItem: ShopItem)
    fun editShopItem (shopItem: ShopItem)
    fun getShopItemById (idShopItem: Int): ShopItem
    fun getShopList () : LiveData<List <ShopItem>>



}
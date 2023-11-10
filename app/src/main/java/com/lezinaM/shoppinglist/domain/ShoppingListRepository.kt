package com.lezinaM.shoppinglist.domain

interface ShoppingListRepository {

    fun addShopItem (shopItem: ShopItem)
    fun deleteShopItem (shopItem: ShopItem)
    fun editShopItem (shopItem: ShopItem)
    fun getShopItemById (idShopItem: Int): ShopItem
    fun getShopList () : List <ShopItem>



}
package com.lezinaM.shoppinglist.data

import com.lezinaM.shoppinglist.domain.ShopItem
import com.lezinaM.shoppinglist.domain.ShoppingListRepository

object ShopListRepositoryImpl: ShoppingListRepository {

    private val shopList = mutableListOf<ShopItem>()
    private  var autoIncrementId = 0


    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID) {
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
    }

    override fun deleteShopItem(shopItem: ShopItem) {
       shopList.remove(shopItem)
    }

    override fun editShopItem(shopItem: ShopItem) {
       val oldElement = getShopItemById(shopItem.id)
        shopList.remove(oldElement)
        addShopItem(shopItem)
    }

    override fun getShopItemById(idShopItem: Int): ShopItem {
        return shopList.find {
            it.id == idShopItem
        }?: throw RuntimeException("Element with id $idShopItem is not found.")
    }

    override fun getShopList(): List<ShopItem> {
        return shopList.toList()
    }
}
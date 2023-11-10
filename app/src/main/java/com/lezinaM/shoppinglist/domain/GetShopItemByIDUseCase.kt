package com.lezinaM.shoppinglist.domain

class GetShopItemByIDUseCase (private val shoppingListRepository: ShoppingListRepository){

    fun getShopItemById (idShopItem: Int): ShopItem {
     return  shoppingListRepository.getShopItemById(idShopItem)
    }
}
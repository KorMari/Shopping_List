package com.lezinaM.shoppinglist.domain

class EditShopItemUseCase (private val shoppingListRepository: ShoppingListRepository) {
    fun editShopItem (shopItem: ShopItem){
shoppingListRepository.editShopItem(shopItem)
    }
}
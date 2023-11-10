package com.lezinaM.shoppinglist.domain

class GetShopListUseCase (private val shoppingListRepository: ShoppingListRepository) {
    fun getShopList () : List <ShopItem> {
      return  shoppingListRepository.getShopList()
    }
}
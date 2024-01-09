package com.lezinaM.shoppinglist.domain

import androidx.lifecycle.LiveData

class GetShopListUseCase (private val shoppingListRepository: ShoppingListRepository) {
    fun getShopList () : LiveData<List <ShopItem>> {
      return  shoppingListRepository.getShopList()
    }
}
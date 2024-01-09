package com.lezinaM.shoppinglist.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lezinaM.shoppinglist.data.ShopListRepositoryImpl
import com.lezinaM.shoppinglist.domain.DeleteShopItemUseCase
import com.lezinaM.shoppinglist.domain.EditShopItemUseCase
import com.lezinaM.shoppinglist.domain.GetShopListUseCase
import com.lezinaM.shoppinglist.domain.ShopItem

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)

    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)

    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()





    fun deleteShopItem(item: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(item)

    }

    fun editShopItem (item: ShopItem){
        editShopItemUseCase.editShopItem(item)

    }

    fun changeEnabled ( shopItem: ShopItem){
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)

    }

}
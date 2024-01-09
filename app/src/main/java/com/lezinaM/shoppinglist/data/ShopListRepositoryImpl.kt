package com.lezinaM.shoppinglist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lezinaM.shoppinglist.domain.ShopItem
import com.lezinaM.shoppinglist.domain.ShoppingListRepository
import kotlin.random.Random

object ShopListRepositoryImpl: ShoppingListRepository {
    private val shopListLD = MutableLiveData<List<ShopItem>>()
    private val shopList = sortedSetOf<ShopItem>({o1,o2 -> o1.id.compareTo(o2.id)})
    private  var autoIncrementId = 0

    init {
        for (i in 0 until 100) {
            val item = ShopItem("Name $i", i, Random.nextBoolean())
            addShopItem(item)
        }
    }



    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID) {
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
        updateShopList()
    }

    override fun deleteShopItem(shopItem: ShopItem) {
       shopList.remove(shopItem)
        updateShopList()
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

    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopListLD
    }

    fun updateShopList (){

        shopListLD.value = shopList.toList()

    }
}
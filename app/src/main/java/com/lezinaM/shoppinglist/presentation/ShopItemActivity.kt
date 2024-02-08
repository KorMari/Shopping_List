package com.lezinaM.shoppinglist.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.shoppinglist.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.lezinaM.shoppinglist.domain.ShopItem

class ShopItemActivity : AppCompatActivity(), ShopItemFragment.OnEditingFinishedListener {

    private var screenMode = MODE_UNKNOWN
    private var shopItemID = ShopItem.UNDEFINED_ID


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_item)
        parseIntent()
        if(savedInstanceState == null) {
            launchRightMode()
        }

    }

    private fun parseIntent() {
        if (!intent.hasExtra(EXTRA_SCREEN_MODE)) {
            throw java.lang.RuntimeException("Param screen mode is absent")
        }
        val mode = intent.getStringExtra(EXTRA_SCREEN_MODE)
        if (mode != MODE_EDIT && mode != MODE_ADD) {
            throw java.lang.RuntimeException("Unknown screen mode $mode")
        }
        screenMode = mode
        if (screenMode == MODE_EDIT) {
            if (!intent.hasExtra(EXTRA_SHOP_ITEM_ID)) {
                throw java.lang.RuntimeException("Param shop item id is absent")
            }
            shopItemID = intent.getIntExtra(EXTRA_SHOP_ITEM_ID, ShopItem.UNDEFINED_ID)
        }


    }

private fun launchRightMode (){
    val fragment = when (screenMode) {
        MODE_EDIT -> ShopItemFragment.newInstanceEditItem(shopItemID)
        MODE_ADD -> ShopItemFragment.newInstanceAddItem()
        else ->  throw java.lang.RuntimeException("Unknown screen mode $screenMode")
    }
    supportFragmentManager.beginTransaction().replace(R.id.shop_item_container, fragment).commit()


}

    companion object {

        private const val EXTRA_SCREEN_MODE = "extra_mode"
        private const val MODE_ADD = "mode_add"
        private const val MODE_UNKNOWN = ""
        private const val MODE_EDIT = "mode_edit"
        private const val EXTRA_SHOP_ITEM_ID = "extra_shop_item_id"

        fun newIntentAddItem(context: Context): Intent {
            val intent = Intent(context, ShopItemActivity::class.java)
            intent.putExtra(EXTRA_SCREEN_MODE, MODE_ADD)
            return intent
        }

        fun newIntentEditItem(context: Context, itemID: Int): Intent {
            val intent = Intent(context, ShopItemActivity::class.java)
            intent.putExtra(EXTRA_SCREEN_MODE, MODE_EDIT)
            intent.putExtra(EXTRA_SHOP_ITEM_ID, itemID)
            return intent
        }
    }

    override fun onEditingFinished() {
        finish()
    }
}
package com.example.shoppinglist.data;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.shoppinglist.ShoppingList;
import com.example.shoppinglist.ShoppingListDao;
import com.example.shoppinglist.ShoppingListDatabase;

import java.util.List;

public class ShoppingListRepository {
    private final LiveData<List<ShoppingList>> mShoppingLists;
    private final ShoppingListDao mShoppingListDao;

    public ShoppingListRepository(Context context) {
        ShoppingListDatabase db = ShoppingListDatabase.getInstance(context);
        mShoppingListDao = db.shoppingListDao();
        mShoppingLists = mShoppingListDao.getAll();
    }

    public LiveData<List<ShoppingList>> getAllShoppingLists() {
        return mShoppingLists;
    }

    public void insert(final ShoppingList shoppingList) {
        ShoppingListDatabase.dbExecutor.execute(
                () -> mShoppingListDao.insert(shoppingList)
        );

    }
}

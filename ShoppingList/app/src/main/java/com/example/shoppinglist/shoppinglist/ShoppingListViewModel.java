package com.example.shoppinglist.shoppinglist;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.shoppinglist.ShoppingList;
import com.example.shoppinglist.data.ShoppingListRepository;

import java.util.List;


//En el constructor cargaremos todas
// las listas de compra para actualizar la vista inmediatamente
public class ShoppingListViewModel extends AndroidViewModel {
    private final ShoppingListRepository mRepository;

    private final LiveData<List<ShoppingList>> mShoppingLists;

    public ShoppingListViewModel(@NonNull Application application) {
        super(application);
        mRepository = new ShoppingListRepository(application);
        mShoppingLists = mRepository.getAllShoppingLists();
    }

    public LiveData<List<ShoppingList>> getShoppingLists() {
        return mShoppingLists;
    }

    public void insert(ShoppingList shoppingList) {
        mRepository.insert(shoppingList);
    }
}

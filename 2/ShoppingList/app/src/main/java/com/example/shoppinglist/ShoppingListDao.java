package com.example.shoppinglist;

import androidx.lifecycle.LiveData;
import androidx.room.*;

import java.util.List;
//clase como un DAO
@Dao
public interface ShoppingListDao {
    //SELECT
    @Query("SELECT * FROM shopping_list")
    //siempre la lista este actulizada
    LiveData<List<ShoppingList>> getAll();

    //insertar
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(ShoppingList shoppingList);


}

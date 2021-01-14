package com.example.shoppinglist;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.*;

//nombre de la tabla
@Entity(tableName = "shopping_list")
public class ShoppingList {
    //clave primaria y no null
    @PrimaryKey
    @NonNull
    //personalizar por el nombre que quiero que en este caso sera "id"
    @ColumnInfo(name = "id")
    private final String mId;

    @NonNull
    @ColumnInfo(name = "name")
    private final String mName;

    //constructor
    public ShoppingList(@NonNull String id, @NonNull String name) {
        mId = id;
        mName = name;
    }
    //getter
    public String getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }
}

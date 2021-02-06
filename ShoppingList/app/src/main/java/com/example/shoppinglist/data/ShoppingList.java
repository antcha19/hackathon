package com.example.shoppinglist.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

    @Nullable
    @ColumnInfo(name = "category")
    private final String mCategory;

    @ColumnInfo(name = "created_date", defaultValue = "CURRENT_TIMESTAMP")
    private final String mCreatedDate;

    @ColumnInfo(name = "last_updated", defaultValue = "CURRENT_TIMESTAMP")
    private final String mLastUpdated;

    //constructor
    public ShoppingList(@NonNull String id, @NonNull String name,
                        @Nullable String category, String createdDate, String lastUpdated) {
        mId = id;
        mName = name;
        mCategory = category;
        mCreatedDate = createdDate;
        mLastUpdated = lastUpdated;
    }
    //getter
    public String getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getCategory() {
        return mCategory;
    }

    public String getCreatedDate() {
        return mCreatedDate;
    }

    public String getLastUpdated() {
        return mLastUpdated;
    }
}

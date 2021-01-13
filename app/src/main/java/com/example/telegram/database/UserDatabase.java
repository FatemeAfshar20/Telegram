package com.example.telegram.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.telegram.database.Repository.UserSchema;
import com.example.telegram.model.User;

@Database(entities = {User.class},version = UserSchema.VERSION)
@TypeConverters({Converter.class})
public abstract class UserDatabase extends RoomDatabase {

    public abstract UserDAO getUserDao();
}

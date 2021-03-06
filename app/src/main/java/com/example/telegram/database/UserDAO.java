package com.example.telegram.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.telegram.model.User;

import java.util.List;
import java.util.UUID;

@Dao
public interface UserDAO {
    @Query(value = "SELECT * FROM userTable")
    List<User> getList();
    @Query(value = "SELECT * FROM userTable WHERE uuid=:id")
    User get(UUID id);
    @Query(value = "SELECT * FROM userTable WHERE name=:name")
    User get(String name);
    @Delete
    void delete(User user);
    @Insert
    void insert(User uer);
    @Update
    void update(User user);
    @Query(value = "SELECT * FROM userTable WHERE name=:username")
    User findUser(String username);
}

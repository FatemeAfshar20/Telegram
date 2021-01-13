package com.example.telegram.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.telegram.database.Repository.UserSchema;
import com.example.telegram.database.Repository.UserSchema.User.UserColumn;

import java.util.Date;
import java.util.UUID;

@Entity(tableName = UserSchema.User.NAME)
public class User {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = UserColumn.UUID)
    private UUID mId;
    @ColumnInfo(name = UserColumn.NAME)
    private String mName;
    @ColumnInfo(name = UserColumn.PHONE_NUMBER)
    private String mPhoneNumber;
    @ColumnInfo(name = UserColumn.DATE)
    private Date mDate;

    public User() {
        mId=UUID.randomUUID();
        mDate=new Date();
    }

    public User(String name, String phoneNumber, Date date,UUID id) {
        mName = name;
        mPhoneNumber = phoneNumber;
        mDate = date;
        mId=id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        mPhoneNumber = phoneNumber;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public UUID getId() {
        return mId;
    }

    public void setId(UUID id) {
        mId = id;
    }
}

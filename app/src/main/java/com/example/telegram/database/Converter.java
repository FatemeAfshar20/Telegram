package com.example.telegram.database;

import androidx.room.TypeConverter;

import java.util.Date;
import java.util.UUID;

public class Converter {

    @TypeConverter
    public Date conLongToDate(Long num){
        return num!=null ? new Date(num) : null;
    }

    @TypeConverter
    public Long conDateToLong(Date date){
        return date!=null ? date.getTime() : null;
    }

    @TypeConverter
    public UUID conStrToUUID(String str){
        return UUID.fromString(str);
    }

    @TypeConverter
    public String conUUIDToStr(UUID uuid){
        return uuid.toString();
    }

}

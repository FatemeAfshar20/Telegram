package com.example.telegram.database.Repository;

public class UserSchema {
    public static final String NAME="user.db";
    public static final int VERSION=1;

    public static final class User{
        public static final String NAME="userTable";

        public static final class UserColumn{
            public static final String UUID="uuid";
            public static final String NAME="name";
            public static final String PHONE_NUMBER="phoneNumber";
            public static final String DATE="date";
        }
    }
}

package com.example.ewallet;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Users.class, Changes.class}, version = 4, exportSchema = false)
public abstract class UsersDatabase extends RoomDatabase {
    public abstract UsersDao usersDao();
    public abstract ChangesDao changesDao();
    public static UsersDatabase INSTANCE;

    public static UsersDatabase getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context, UsersDatabase.class, "UsersDatabase").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return INSTANCE;
    }
}

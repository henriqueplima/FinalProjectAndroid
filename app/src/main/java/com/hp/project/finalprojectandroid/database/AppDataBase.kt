package com.hp.project.finalprojectandroid.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.hp.project.finalprojectandroid.dao.GameDao
import com.hp.project.finalprojectandroid.models.Game

@Database(entities = [Game::class], version = 1)
abstract class AppDataBase:RoomDatabase(){
    abstract fun gameDao(): GameDao

    companion object {

        var INSTANCE: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext,
                    AppDataBase::class.java,
                    "gamesdbs")
                    .build()
            }
            return INSTANCE
        }
    }

}
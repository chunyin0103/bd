package com.example.bdt

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database (entities = [DB::class],version = 1 )
abstract class bdDatabase:RoomDatabase() {
    abstract fun bdDao():bddao
    companion object{
        @Volatile
        private var INSTANCE:bdDatabase?=null
        fun getInstance(context:Context):bdDatabase{
            synchronized(this){
                var instance= INSTANCE
                if(instance == null){
                    instance= Room.databaseBuilder( context.applicationContext,bdDatabase::class.java,"birthday_database")
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE=instance
                }
                return instance
            }
        }
    }
}
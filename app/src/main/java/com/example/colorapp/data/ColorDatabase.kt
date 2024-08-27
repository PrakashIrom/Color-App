package com.example.colorapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CardColor::class], version = 2, exportSchema = false)
abstract class ColorDatabase : RoomDatabase() {
    abstract fun colorDao(): ColorDao

    companion object{
        @Volatile
        private var Instance: ColorDatabase? = null

        fun getDatabase(context: Context): ColorDatabase{
            return Instance ?: synchronized(this){
                Room.databaseBuilder(context, ColorDatabase::class.java, "color_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also{Instance = it}
            }
        }
    }

}

package com.example.colorapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ColorDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(color: CardColor)

    @Query("SELECT * FROM CardColors")
    fun getAllColors(): Flow<List<CardColor>>
}
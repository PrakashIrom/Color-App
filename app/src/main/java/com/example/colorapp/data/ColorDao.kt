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

    @Query("SELECT * FROM CardColors WHERE isSynced = 0")
    fun getUnsyncedColors(): Flow<List<CardColor>>

    @Query("SELECT COUNT(*) FROM CardColors WHERE isSynced = 0")
    fun countUnsyncedColors(): Flow<Int>

    @Query("UPDATE CardColors SET isSynced = 1 WHERE isSynced = 0")
    suspend fun updateUnsyncedColors()

}
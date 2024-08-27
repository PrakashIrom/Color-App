package com.example.colorapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CardColors")
data class CardColor(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val colorCode: String,
    val dateCreated: String
)

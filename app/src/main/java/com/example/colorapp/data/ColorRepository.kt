package com.example.colorapp.data

import kotlinx.coroutines.flow.Flow

interface ColorRepository {

    suspend fun insertColor(color: CardColor)

    fun getAllColors(): Flow<List<CardColor>>
}
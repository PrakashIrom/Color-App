package com.example.colorapp.data

import kotlinx.coroutines.flow.Flow

class ColorOfflineRepository(private val colorDao: ColorDao) : ColorRepository {

    override suspend fun insertColor(color: CardColor)= colorDao.insert(color)

    override fun getAllColors(): Flow<List<CardColor>> = colorDao.getAllColors()

    override fun getUnsyncedColorsCount(): Flow<Int> = colorDao.countUnsyncedColors()

    override suspend fun updateUnsyncedColors() = colorDao.updateUnsyncedColors()

    override fun getUnsyncedColors(): Flow<List<CardColor>> = colorDao.getUnsyncedColors()

}
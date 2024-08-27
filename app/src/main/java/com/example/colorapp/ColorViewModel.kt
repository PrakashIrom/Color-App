package com.example.colorapp

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.colorapp.data.CardColor
import com.example.colorapp.data.ColorRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class ColorViewModel(private val colorRepository: ColorRepository): ViewModel() {

    private val _colors = MutableStateFlow<List<CardColor>>(emptyList())
    val colors: StateFlow<List<CardColor>> = _colors

    private val _count = MutableStateFlow(0)
    val count: StateFlow<Int> = _count

    suspend fun insertColor(color: CardColor){
        colorRepository.insertColor(color)
    }

    suspend fun updateUnsyncedColor(){
            colorRepository.updateUnsyncedColors()
    }

    suspend fun getUnsyncedColors(): List<CardColor> {
       return colorRepository.getUnsyncedColors().first()
    }

    init{
        viewModelScope.launch {
            colorRepository.getAllColors().collect{
                _colors.value = it
            }
        }

        viewModelScope.launch {
            colorRepository.getUnsyncedColorsCount().collect { count ->
                _count.value = count
                Log.d("Count", count.toString())
            }
        }

    }

}
package com.example.colorapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.colorapp.data.CardColor
import com.example.colorapp.data.ColorRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ColorViewModel(private val colorRepository: ColorRepository): ViewModel() {

    private val _colors = MutableStateFlow<List<CardColor>>(emptyList())
    val colors: StateFlow<List<CardColor>> = _colors

    suspend fun insertColor(color: CardColor){
        colorRepository.insertColor(color)
    }

    init{
        viewModelScope.launch {
            colorRepository.getAllColors().collect{
                _colors.value = it
            }
        }
    }

}
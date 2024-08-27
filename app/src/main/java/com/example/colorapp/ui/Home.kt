package com.example.colorapp.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.colorapp.ColorViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(viewModel: ColorViewModel = koinViewModel()){

    val colorState = viewModel.colors.collectAsState()

    Scaffold(
        topBar = { TopBar()},
        floatingActionButton = { FAB()}
    ){
        LazyVerticalGrid(columns = GridCells.Fixed(2),modifier=Modifier.padding(it)) {
            items(colorState.value){color ->
            CardScreen(color)
            }
        }
    }
}


package com.example.colorapp.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(){
    val listCards = remember{mutableStateListOf<Cards>()}
    Scaffold(
        topBar = { TopBar()},
        floatingActionButton = { FAB(listCards)}
    ){
        LazyVerticalGrid(columns = GridCells.Fixed(2),modifier=Modifier.padding(it)) {
            items(listCards){item ->
            CardScreen(item)
            }
        }
    }
}


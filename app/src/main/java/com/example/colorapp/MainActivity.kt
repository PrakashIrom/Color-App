package com.example.colorapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.example.colorapp.ui.HomeScreen
import com.example.colorapp.ui.theme.ColorAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColorAppTheme{
                Modifier.fillMaxSize()
                HomeScreen()
            }
        }
    }
}

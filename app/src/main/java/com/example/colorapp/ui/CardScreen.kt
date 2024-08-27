package com.example.colorapp.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.colorapp.ui.theme.ColorAppTheme

@Composable
fun CardScreen(color: com.example.colorapp.data.CardColor){

    Card(
        colors = CardDefaults.cardColors(containerColor = Color(android.graphics.Color.parseColor(color.colorCode))),
        modifier = Modifier.padding(16.dp).size(150.dp)) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column {
                Text(
                    color.colorCode,
                    modifier = Modifier.padding(start = 10.dp),
                    color = Color.White
                )
                Divider(
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth() // Divider extends to the full width of the card
                        .padding(
                            start = 10.dp,
                            end = 70.dp
                        ) // Add padding to the divider)
                )
            }
            Column(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(10.dp)
            ) {
                Text(
                    text = "Created At",
                    color = Color.White
                )
                Text(
                    text = color.dateCreated,
                    color = Color.White
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TestCardScreen(){
    ColorAppTheme {
        //CardScreen()
    }
}
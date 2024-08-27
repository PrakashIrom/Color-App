package com.example.colorapp.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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
fun CardScreen(item: Cards){

    // Generate a random color hex string
    //val randomColorHex = generateRandomColor()
    // Convert the hex string to a Color object
    /*val cardColor = colorFromHex(randomColorHex)
    val currentTimeMillis = System.currentTimeMillis()
    val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val formattedDate = dateFormat.format(Date(currentTimeMillis))
*/
                Card(
                    colors = CardDefaults.cardColors(containerColor = item.colorCode),
                   modifier = Modifier.padding(16.dp).size(150.dp)
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Column {
                            Text(
                                item.colorName,
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
                                text = item.dataCreated,
                                color = Color.White
                            )
                        }
                }
            }
}

/*
fun generateRandomColor(): String {
    val random = java.util.Random()
    val nextInt = random.nextInt(0xFFFFFF + 1)
    // Format the integer to a 6-digit hex string and prepend the '#' character
    return String.format("#%06X", nextInt)
}

fun colorFromHex(hex: String): Color {
    return Color(android.graphics.Color.parseColor(hex))
}*/

@Preview(showBackground = true)
@Composable
fun TestCardScreen(){
    ColorAppTheme {
        //CardScreen()
    }
}
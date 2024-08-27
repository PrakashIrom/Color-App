package com.example.colorapp.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.colorapp.ui.theme.Purple40
import com.example.colorapp.ui.theme.Purple80
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class Cards(
    val colorCode: Color,
    val dataCreated: String,
    val colorName: String
)

@Composable
fun FAB(listCards: SnapshotStateList<Cards>){

    Button(onClick = {
        // Generate a random color hex string
        val randomColorHex = generateRandomColor()
        // Convert the hex string to a Color object
        val cardColor = colorFromHex(randomColorHex)
        val currentTimeMillis = System.currentTimeMillis()
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val formattedDate = dateFormat.format(Date(currentTimeMillis))
        listCards.add(Cards(cardColor, formattedDate, randomColorHex))},
        colors = ButtonDefaults.buttonColors(
            containerColor = Purple80, // Set the background color
            contentColor = Color.White, // Set the text/icon color
        ), modifier = Modifier.sizeIn(minWidth = 0.dp, minHeight = 0.dp)
        ){
        Text(text = "Add Color",
            color = Purple40
            )
        Spacer(modifier = Modifier.width(8.dp))
        Icon(
            imageVector = Icons.Default.AddCircle,
            contentDescription = "Sync Icon",
            tint = Purple40
        )
    }
}

fun generateRandomColor(): String {
    val random = java.util.Random()
    val nextInt = random.nextInt(0xFFFFFF + 1)
    // Format the integer to a 6-digit hex string and prepend the '#' character
    return String.format("#%06X", nextInt)
}

fun colorFromHex(hex: String): Color {
    return Color(android.graphics.Color.parseColor(hex))
}
package com.example.colorapp.ui

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Sync
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.colorapp.ColorFirebaseViewModel
import com.example.colorapp.ColorViewModel
import com.example.colorapp.ui.theme.ColorAppTheme
import com.example.colorapp.ui.theme.Purple40
import com.example.colorapp.ui.theme.Purple80
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun TopBar(countState: State<Int>, colorViewModel: ColorViewModel, fbViewModel: ColorFirebaseViewModel = koinViewModel()) {

    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current

    Box(modifier = Modifier
        .fillMaxWidth()
        .height(70.dp)
        .background(Purple40),){
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
        ){
                Text("Color App",
                    color = Color.White,
                    fontSize = 25.sp,
                    modifier = Modifier.padding(start = 10.dp, top = 15.dp)
                    )
            Button(
                onClick = {
                    coroutineScope.launch {
                    val colorList = colorViewModel.getUnsyncedColors()
                        if(fbViewModel.isNetworkAvailable(context)){
                            fbViewModel.writeColor(colorList)
                            colorViewModel.updateUnsyncedColor()
                        }
                        else{
                            Toast.makeText(context, "No internet connection. Please try again later.", Toast.LENGTH_SHORT).show()
                        }
                    }
                },
                modifier = Modifier.padding(end = 10.dp, top = 15.dp).wrapContentSize(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Purple80,
                    contentColor = Color.White
                )
            ) {
                Text(text = countState.value.toString())
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    imageVector = Icons.Filled.Sync,
                    contentDescription = "Sync Icon",
                    tint = Purple40,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TestTopScreen(){
    ColorAppTheme {
    }
}
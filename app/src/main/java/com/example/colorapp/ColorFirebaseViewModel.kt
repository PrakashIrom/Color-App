package com.example.colorapp

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.colorapp.data.CardColor
import com.example.colorapp.data.ColorFirebaseData
import com.google.firebase.database.FirebaseDatabase

class ColorFirebaseViewModel(private val db:FirebaseDatabase): ViewModel() {

    fun writeColor(colors: List<CardColor>){

        val dbReference = db.reference.child("colors")
        val updates = mutableMapOf<String, Any>()

        colors.forEach{color->
            val colorId = dbReference.push().key
            if(colorId!=null){
                val colorFirebaseData = ColorFirebaseData(
                    colorCode = color.colorCode,
                    dateCreated = color.dateCreated
                )
                updates["$colorId"] = colorFirebaseData
            }
        }

        dbReference.updateChildren(updates)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("Firebase", "All colors saved successfully")
                } else {
                    Log.e("Firebase", "Error saving colors", task.exception)
                }
            }

    }

    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        return networkCapabilities != null &&
                (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                        networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                        networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET))
    }

}
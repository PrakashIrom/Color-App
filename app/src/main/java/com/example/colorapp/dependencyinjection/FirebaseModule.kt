package com.example.colorapp.dependencyinjection

import com.example.colorapp.ColorFirebaseViewModel
import com.google.firebase.database.FirebaseDatabase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val fbModule=module{

    single { FirebaseDatabase.getInstance() }
    viewModel { ColorFirebaseViewModel(get()) }
}
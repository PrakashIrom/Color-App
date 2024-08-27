package com.example.colorapp.dependencyinjection

import com.example.colorapp.ColorViewModel
import com.example.colorapp.data.ColorDatabase
import com.example.colorapp.data.ColorOfflineRepository
import com.example.colorapp.data.ColorRepository
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module{

    single{
        ColorDatabase.getDatabase(androidContext())
    }
    single{
        get<ColorDatabase>().colorDao()
    }

    single<ColorRepository>{
        ColorOfflineRepository(get())
    }

    viewModel{
        ColorViewModel(get())
    }

}
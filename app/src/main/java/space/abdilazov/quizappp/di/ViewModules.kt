package com.example.quizapp.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import space.abdilazov.quizappp.ui.fragments.mainFragment.MainViewModel

val viewModules:Module = module {
    viewModel { MainViewModel(get()) }
}
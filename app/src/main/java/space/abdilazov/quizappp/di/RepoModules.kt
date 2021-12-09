package com.example.quizapp.di

import space.abdilazov.quizappp.ui.repository.Repository
import org.koin.core.module.Module
import org.koin.dsl.module

val repoModules: Module = module {
    single { Repository(get()) }
}
package com.example.quizapp.di

import android.content.Context
import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module
import space.abdilazov.quizappp.local.ResultDao
import space.abdilazov.quizappp.local.ResultDataBase

private fun creatDataBase(context: Context) =
    Room.databaseBuilder(
        context.applicationContext,
        ResultDataBase::class.java,
        "article_db.db"
    )
        .build()


private fun getResultDao(resultDataBase: ResultDataBase): ResultDao {
    return resultDataBase.getResultDao()
}
var roomModule:Module = module {
    single { creatDataBase(androidContext()) }
    single { getResultDao(get()) }
}
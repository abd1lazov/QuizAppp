package space.abdilazov.quizappp.local

import androidx.room.Database
import androidx.room.RoomDatabase
import space.abdilazov.quizappp.local.model.RoomResult

@Database(entities = [RoomResult::class], version = 1)
abstract class ResultDataBase: RoomDatabase() {

    abstract fun getResultDao(): ResultDao
}
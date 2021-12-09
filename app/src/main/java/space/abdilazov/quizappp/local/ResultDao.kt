package space.abdilazov.quizappp.local

import androidx.lifecycle.LiveData
import androidx.room.*
import space.abdilazov.quizappp.local.model.RoomResult

@Dao
interface ResultDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(roomResult: RoomResult):Long

    @Query("SELECT * FROM questions")
    fun getAllResults(): LiveData<List<RoomResult>>

    @Delete
    suspend fun deleteResult(roomResult: RoomResult)

}
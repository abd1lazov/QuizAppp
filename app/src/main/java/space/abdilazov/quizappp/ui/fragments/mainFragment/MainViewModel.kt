package space.abdilazov.quizappp.ui.fragments.mainFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.load.engine.Resource
import com.example.quizapp.model.QuizResponse
import space.abdilazov.quizappp.ui.repository.Repository
import kotlinx.coroutines.launch
import space.abdilazov.quizappp.local.model.RoomResult

class MainViewModel(private val repository: Repository): ViewModel() {

    fun getAllQuestions(
        amount: Int,
        category: Int,
        difficulty: String,
        type: String
    ): LiveData<space.abdilazov.quizappp.core.network.Resource<QuizResponse>> {
        return repository.getAllQuestions(amount, category, difficulty, type)
    }

    fun saveQuestions(roomResult: RoomResult) = viewModelScope.launch {
        repository.upsert(roomResult)
    }

    fun getSavedQuestions() = repository.getSavedQuestions()

    fun deleteQuestions(roomResult: RoomResult) = viewModelScope.launch {
        repository.deleteResults(roomResult)
    }
}
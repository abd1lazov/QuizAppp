package space.abdilazov.quizappp.ui.repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import space.abdilazov.quizappp.ui.fragments.mainFragment.MainViewModel


@Suppress("UNCHECKED_CAST")
class QuizViewModelProviderFactory(private val repository: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}
package space.abdilazov.quizappp.ui.fragments.historyFragment

import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel
import space.abdilazov.quizappp.core.ui.BaseFragment
import space.abdilazov.quizappp.databinding.FragmentHistoryBinding
import space.abdilazov.quizappp.local.model.RoomResult
import space.abdilazov.quizappp.ui.fragments.historyFragment.adapter.QuestionAdapter
import space.abdilazov.quizappp.ui.fragments.mainFragment.MainViewModel

class HistoryFragment : BaseFragment<FragmentHistoryBinding>(FragmentHistoryBinding::inflate) {

    private val viewModel: MainViewModel by viewModel()
    private lateinit var questionAdapter: QuestionAdapter
    private var list: ArrayList<RoomResult> = arrayListOf()

    override fun setupLiveData() {
        viewModel.getSavedQuestions().observe(viewLifecycleOwner, {
            list = it as ArrayList<RoomResult>
            questionAdapter.addQuestions(list)
        })
    }

    override fun setupUI() {
        questionAdapter = QuestionAdapter(list)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = questionAdapter
        }
    }
}